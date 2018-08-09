package com.n256coding.crosssiterequestdscookiedemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {

    @GetMapping("/login")
    public String getLoginPage(Principal user) {
        if (user != null) {
            return "redirect: ";
        }
        return "login";
    }

    @GetMapping({"/home", "/"})
    public String getHomePage() {
        return "home";
    }
}
