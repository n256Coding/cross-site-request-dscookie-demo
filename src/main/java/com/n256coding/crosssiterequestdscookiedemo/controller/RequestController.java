package com.n256coding.crosssiterequestdscookiedemo.controller;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Map;

@RestController
public class RequestController {

    @PostMapping(value = "/mydata")
    public Map<String, String> setInformation(@CookieValue("JSESSIONID") String sessionId,
                                              @CookieValue("csrf_token") String csrfTokenInCookie,
                                              HttpServletRequest request, HttpServletResponse response) {
        String csrfTokenInBody = request.getParameter("csrf_token");
        String accountNumber = request.getParameter("receiver_account_number");
        double value = Double.parseDouble(request.getParameter("value"));

        System.out.println("CSRF token in cookie: " + csrfTokenInCookie);
        System.out.println("CSRF token in body: " + csrfTokenInBody);


        if (csrfTokenInBody == null || csrfTokenInCookie == null) {
            response.setStatus(403);    //Forbidden
            System.out.println("CSRF tokens not matched, connection prevented");
            return Collections.singletonMap("response", "forbidden");
        }

        if (csrfTokenInBody.equals(csrfTokenInCookie)) {
            response.setStatus(200);    //Ok
            System.out.println("CSRF tokens matched, connection allowed");
            return Collections.singletonMap("response", "success");
        } else {
            response.setStatus(403);    //Forbidden
            System.out.println("CSRF tokens not matching, connection prevented");
            return Collections.singletonMap("response", "forbidden");
        }
    }

}
