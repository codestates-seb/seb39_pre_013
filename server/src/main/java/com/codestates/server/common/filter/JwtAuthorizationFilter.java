package com.codestates.server.common.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.codestates.server.common.oauth.PrincipalDetails;
import com.codestates.server.user.entity.User;
import com.codestates.server.user.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;


@Slf4j
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    private final String JWT_KEY;
    private final UserRepository userRepository;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, String jwt_key, UserRepository userRepository) {
        super(authenticationManager);
        JWT_KEY = jwt_key;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("인증이나 권한이 필요한 주소 요청됨");
        String jwtHeader = request.getHeader("access_token");
        String refreshHeader = request.getHeader("refresh_token");
        if (jwtHeader == null || !jwtHeader.startsWith("Bearer")) {
            chain.doFilter(request,response);
            return;
        }

        String username = null;
        try {
            String jwtToken = jwtHeader.replace("Bearer ", "");

            username = JWT.require(Algorithm.HMAC512(JWT_KEY)).build().verify(jwtToken).getClaim("sub").asString();
        }catch (com.auth0.jwt.exceptions.TokenExpiredException e){
            response.setHeader("access_token","token expired");
            response.setHeader("refresh_token", refreshHeader);
            //리다이렉트 시키자
            new ObjectMapper().writeValue(response.getOutputStream(), new HashMap<String,String>(){{put("msg","accessToken이 만료되었습니다.");}});
            log.info(e.getMessage());
        }

        if (username != null){
            User user = userRepository.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("잘못된 토큰입니다."));
            PrincipalDetails principalDetails = new PrincipalDetails(user);
            Authentication authentication = new UsernamePasswordAuthenticationToken(principalDetails,null, principalDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(request,response);
        }
//        else {
//            super.doFilterInternal(request, response, chain);
//        }
    }
}
