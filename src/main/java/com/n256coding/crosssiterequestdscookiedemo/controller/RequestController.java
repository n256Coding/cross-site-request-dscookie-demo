package com.n256coding.crosssiterequestdscookiedemo.controller;

import com.n256coding.crosssiterequestdscookiedemo.model.MyData;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Map;

@RestController
public class RequestController {

//    @PostMapping("/csrf")
//    public Map<String, String> getCsrfOf(@CookieValue("JSESSIONID") String sessionId) {
//        return Collections.singletonMap("csrf", sessionStore.getCsrfOf(sessionId));
//    }

    @PostMapping(value = "/mydata")
    public String setInformation(@CookieValue("JSESSIONID") String sessionId, @RequestBody MyData myData,
                                              HttpServletRequest request, HttpServletResponse response) {

//        new ModelAndView()
//        if (sessionStore.getCsrfOf(sessionId).equals(myData.csrf_token)) {
//            return Collections.singletonMap("response", "success");
//        } else {
//            return Collections.singletonMap("response", "invalid");
//        }
        return "Hello";
    }

    @GetMapping("/test")
    public Map<String, String> getTestItem(HttpServletRequest request, HttpServletResponse response){
        Cookie cookie = new Cookie("test_cookie_name", "test_cookie_value");
        cookie.setSecure(false);
        cookie.setMaxAge(60 * 60 * 24);
        cookie.setPath("/");

        response.addCookie(cookie);
        return Collections.singletonMap("response", "success");
    }
}
