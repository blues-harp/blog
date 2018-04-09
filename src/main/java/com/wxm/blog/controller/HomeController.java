package com.wxm.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jerry.wxm
 * @since 2018-04-08
 */

@RestController
public class HomeController {

    @GetMapping("/")
    public String home(HttpServletRequest request) {
        String clientIp = request.getRemoteHost();
        return "clientIp=" + clientIp;
    }
}
