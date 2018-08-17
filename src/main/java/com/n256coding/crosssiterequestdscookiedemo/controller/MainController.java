package com.n256coding.crosssiterequestdscookiedemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.UUID;

@Controller
public class MainController {

    @GetMapping("/login")
    public String getLoginPage(Principal user, HttpServletRequest request, HttpServletResponse response) {
        if (user != null) {
            return "redirect: ";
        }

        String csrfToken = UUID.randomUUID().toString();
        Cookie cookie = new Cookie("csrf_token_name", csrfToken);
        cookie.setSecure(true);
        cookie.setHttpOnly(false);

        response.addCookie(cookie);
        return "login";
    }

    @GetMapping({"/home", "/"})
    public String getHomePage(HttpServletRequest request, HttpServletResponse response) {
        return "home";
    }
}
