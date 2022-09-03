package com.codestates.server.common.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.codestates.server.common.oauth.PrincipalDetails;
import com.codestates.server.user.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;


@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final String JWT_KEY;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        log.info("로그인 요청");
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            User user = objectMapper.readValue(request.getInputStream(), User.class);
            System.out.println(user.getEmail());
            System.out.println(user.getPassword());
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            return authentication;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        log.info("인증에 성공하였습니다.");
        PrincipalDetails principalDetails = (PrincipalDetails) authResult.getPrincipal();
        log.info("해당유저는"+ principalDetails.getUsername());
        System.out.println(JWT_KEY);
        String accessToken = createAccessToken(principalDetails, 30);
        String refreshToken = createRefreshToken(principalDetails, 600);

        returnResponseEntity(response, accessToken, refreshToken);
    }

    private String createAccessToken(PrincipalDetails principalDetails, int x) {
        String accessToken = JWT.create()
                .withSubject(principalDetails.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + (60*1000* x)))
                .withClaim("id", principalDetails.getUser().getId())
                .withClaim("nickname", principalDetails.getUser().getNickname())
                .sign(Algorithm.HMAC512(JWT_KEY));
        return accessToken;
    }
    private String createRefreshToken(PrincipalDetails principalDetails, int x) {
        String accessToken = JWT.create()
                .withSubject("refresh")
                .withClaim("email",principalDetails.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + (60*1000* x)))
                .withClaim("id", principalDetails.getUser().getId())
                .withClaim("nickname", principalDetails.getUser().getNickname())
                .sign(Algorithm.HMAC512(JWT_KEY));
        return accessToken;
    }
    private void returnResponseEntity(HttpServletResponse response, String accessToken, String refreshToken) throws IOException {
        response.addHeader("accessToken","Bearer " + accessToken);
        response.addHeader("refreshToken", "Bearer " + refreshToken);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("msg", "로그인이 완료되었습니다.");
        new ObjectMapper().writeValue(response.getOutputStream(),body);
    }
}
