package com.n256coding.crosssiterequestdscookiedemo.configuration;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Component
public class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Cookie cookie = new Cookie("csrf_token", UUID.randomUUID().toString());
        cookie.setHttpOnly(false);
        response.addCookie(cookie);
        super.onAuthenticationSuccess(request, response, authentication);
    }
}