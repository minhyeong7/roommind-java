package com.roomgenius.furniture_recommendation.controller;

import com.roomgenius.furniture_recommendation.service.OAuthServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OAuthController {

    private final OAuthServiceImpl oAuthServiceImpl;

    @Value("${frontend.url:http://localhost:3000}")
    private String frontendUrl;

    private static final String LOGIN_SUCCESS_PATH = "/login-success";
    private static final String LOGIN_ERROR_PATH   = "/login-error";


    // ============================================================
    // 🔹 카카오 로그인
    // ============================================================

    @Value("${kakao.clientId}")
    private String kakaoClientId;

    @Value("${kakao.redirectUri}")
    private String kakaoRedirectUri;


    @GetMapping("/oauth/kakao")
    public void redirectToKakaoLogin(HttpServletResponse response) throws IOException {
        String kakaoAuthUrl = "https://kauth.kakao.com/oauth/authorize"
                + "?client_id=" + kakaoClientId
                + "&redirect_uri=" + kakaoRedirectUri
                + "&response_type=code"
                + "&prompt=select_account";

        response.sendRedirect(kakaoAuthUrl);
    }


    @GetMapping("/social")
    public void handleKakaoCallback(
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String error,
            @RequestParam(name = "error_description", required = false) String errorDescription,
            HttpServletResponse response
    ) throws IOException {

        if (error != null) {
            String redirectUrl = frontendUrl + LOGIN_ERROR_PATH
                    + "?provider=kakao&reason=cancel";
            response.sendRedirect(redirectUrl);
            return;
        }

        try {
            Map<String, Object> loginResult = oAuthServiceImpl.loginWithKakao(code);

            String redirectUrl = frontendUrl + LOGIN_SUCCESS_PATH
                    + "?token=" + encode(loginResult.get("token"))
                    + "&userName=" + encode(loginResult.get("username"))
                    + "&socialType=" + loginResult.get("socialType")
                    + "&role=" + loginResult.get("role")
                    + "&userId=" + loginResult.get("userId")
                    + "&email=" + encode(loginResult.get("email"));

            response.sendRedirect(redirectUrl);

        } catch (Exception e) {
            String redirectUrl = frontendUrl + LOGIN_ERROR_PATH
                    + "?provider=kakao&reason=error";
            response.sendRedirect(redirectUrl);
        }
    }


    // ============================================================
    // 🔹 네이버 로그인
    // ============================================================

    @Value("${naver.clientId}")
    private String naverClientId;

    @Value("${naver.redirectUri}")
    private String naverRedirectUri;


    @GetMapping("/oauth/naver")
    public void redirectToNaverLogin(HttpServletResponse response) throws IOException {

        String state = UUID.randomUUID().toString();

        String naverAuthUrl =
                "https://nid.naver.com/oauth2.0/authorize"
                        + "?response_type=code"
                        + "&client_id=" + naverClientId
                        + "&redirect_uri=" + naverRedirectUri
                        + "&state=" + state
                        + "&auth_type=reprompt";

        response.sendRedirect(naverAuthUrl);
    }


    @GetMapping("/social/naver")
    public void handleNaverCallback(
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String state,
            @RequestParam(required = false) String error,
            @RequestParam(name = "error_description", required = false) String errorDescription,
            HttpServletResponse response
    ) throws IOException {

        if (error != null) {
            String redirectUrl = frontendUrl + LOGIN_ERROR_PATH
                    + "?provider=naver&reason=cancel";
            response.sendRedirect(redirectUrl);
            return;
        }

        try {
            Map<String, Object> loginResult = oAuthServiceImpl.loginWithNaver(code, state);

            String redirectUrl = frontendUrl + LOGIN_SUCCESS_PATH
                    + "?token=" + encode(loginResult.get("token"))
                    + "&userName=" + encode(loginResult.get("username"))
                    + "&socialType=" + loginResult.get("socialType")
                    + "&role=" + loginResult.get("role")
                    + "&userId=" + loginResult.get("userId")
                    + "&email=" + encode(loginResult.get("email"));

            response.sendRedirect(redirectUrl);

        } catch (Exception e) {
            String redirectUrl = frontendUrl + LOGIN_ERROR_PATH
                    + "?provider=naver&reason=error";
            response.sendRedirect(redirectUrl);
        }
    }


    // ============================================================
    // 🔹 구글 로그인
    // ============================================================

    @Value("${google.clientId}")
    private String googleClientId;

    @Value("${google.redirectUri}")
    private String googleRedirectUri;

    @Value("${google.authUri}")
    private String googleAuthUri;


    @GetMapping("/oauth/google")
    public void redirectToGoogleLogin(HttpServletResponse response) throws IOException {

        String encodedRedirect = encode(googleRedirectUri);

        String googleAuthUrl = googleAuthUri
                + "?client_id=" + googleClientId
                + "&redirect_uri=" + encodedRedirect
                + "&response_type=code"
                + "&scope=openid%20email%20profile"
                + "&prompt=select_account";

        response.sendRedirect(googleAuthUrl);
    }


    @GetMapping("/social/google")
    public void handleGoogleCallback(
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String error,
            @RequestParam(name = "error_description", required = false) String errorDescription,
            HttpServletResponse response
    ) throws IOException {

        if (error != null) {
            String redirectUrl = frontendUrl + LOGIN_ERROR_PATH
                    + "?provider=google&reason=cancel";
            response.sendRedirect(redirectUrl);
            return;
        }

        try {
            Map<String, Object> loginResult = oAuthServiceImpl.loginWithGoogle(code);

            String redirectUrl = frontendUrl + LOGIN_SUCCESS_PATH
                    + "?token=" + encode(loginResult.get("token"))
                    + "&userName=" + encode(loginResult.get("username"))
                    + "&socialType=" + loginResult.get("socialType")
                    + "&role=" + loginResult.get("role")
                    + "&userId=" + loginResult.get("userId")
                    + "&email=" + encode(loginResult.get("email"));

            response.sendRedirect(redirectUrl);

        } catch (Exception e) {
            String redirectUrl = frontendUrl + LOGIN_ERROR_PATH
                    + "?provider=google&reason=error";
            response.sendRedirect(redirectUrl);
        }
    }


    // ============================================================
    // 공통 인코딩 메서드
    // ============================================================

    private String encode(Object value) {
        if (value == null) return "";
        return URLEncoder.encode(value.toString(), StandardCharsets.UTF_8);
    }

}
