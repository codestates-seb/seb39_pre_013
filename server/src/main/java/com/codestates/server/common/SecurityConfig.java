package com.codestates.server.common;

import com.codestates.server.common.filter.JwtAuthenticationFilter;
import com.codestates.server.common.filter.JwtAuthorizationFilter;
import com.codestates.server.user.mapper.UserMapper;
import com.codestates.server.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.CorsFilter;

import java.io.PrintWriter;

@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {
    @Value("${jwt.secret.key}")
    private String JWT_KEY;
    private final CorsFilter corsFilter;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();//stateless한 서버에는 인증정보를 저장하지않으므로 csrf코드가 불필요하다.
        http.headers().frameOptions().disable();
//        http.exceptionHandling()
//                .accessDeniedHandler(accessDeniedHandler)
//                .authenticationEntryPoint(unauthorizedEntryPoint);

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().disable()
                .httpBasic().disable()
                .apply(new CustomDsl())
                .and()
                .authorizeRequests()
                .antMatchers("/api/v1/users/login").permitAll()
                .antMatchers("/api/v1/users/signup","/api/v1/users/refresh").permitAll()
//                .antMatchers("/api/v1/users/**").access("hasRole('ROLE_USER')")
                .anyRequest().permitAll()

        ;
        return http.build();
    }
    @Component
    public class CustomDsl extends AbstractHttpConfigurer<CustomDsl,HttpSecurity>{
        @Override
        public void configure(HttpSecurity builder) throws Exception {
            AuthenticationManager authenticationManager = builder.getSharedObject(AuthenticationManager.class);
            builder.addFilter(corsFilter)
                    .addFilter(getJwtAuthenticationFilter(authenticationManager))
                    .addFilter(new JwtAuthorizationFilter(authenticationManager, JWT_KEY, userRepository));
        }

        private JwtAuthenticationFilter getJwtAuthenticationFilter(AuthenticationManager authenticationManager) {
            JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager,JWT_KEY,userMapper);
            jwtAuthenticationFilter.setFilterProcessesUrl("/api/v1/users/login");
            return jwtAuthenticationFilter;
        }
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    private final AuthenticationEntryPoint unauthorizedEntryPoint =
            (request, response, authException) -> {
//                ErrorResponse fail = ...; // Custom error response.
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
//                String json = objectMapper.writeValueAsString(fail);
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                PrintWriter writer = response.getWriter();
//                writer.write(json);
                writer.flush();
            };
    private final AccessDeniedHandler accessDeniedHandler =
            (request, response, accessDeniedException) -> {
//                ErrorResponse fail = ...;
                response.setStatus(HttpStatus.FORBIDDEN.value());
//                String json = objectMapper.writeValueAsString(fail);
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                PrintWriter writer = response.getWriter();
//                writer.write(json);
                writer.flush();
            };
}
