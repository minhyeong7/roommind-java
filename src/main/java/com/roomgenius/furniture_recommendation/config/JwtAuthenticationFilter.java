package com.roomgenius.furniture_recommendation.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        try {
            // 1. Request Header에서 JWT 토큰 추출
            String token = getJwtFromRequest(request);

            // 2. 토큰 유효성 검증
            if (StringUtils.hasText(token) && jwtTokenProvider.validateToken(token)) {

                // 3. 토큰에서 사용자 정보 추출
                String email = jwtTokenProvider.getEmailFromToken(token);
                String role = jwtTokenProvider.getRoleFromToken(token);

                // 4. Spring Security 인증 객체 생성
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                email,
                                null,
                                Collections.singleton(new SimpleGrantedAuthority("ROLE_" + role))
                        );

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // 5. SecurityContext에 인증 정보 저장
                SecurityContextHolder.getContext().setAuthentication(authentication);

                log.debug("인증 성공: email={}, role={}", email, role);
            }
        } catch (Exception e) {
            log.error("JWT 인증 실패", e);
        }

        filterChain.doFilter(request, response);
    }

    /**
     * Request Header에서 JWT 토큰 추출
     * Authorization: Bearer {token}
     */
    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7); // "Bearer " 이후의 토큰만 추출
        }

        return null;
    }
}