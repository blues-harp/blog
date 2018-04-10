package com.wxm.blog.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;

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

        try {

            JSONObject jsonObject = new JSONObject();

            Map<String, String> headerMap = new HashMap<>();
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerKey = headerNames.nextElement();
                headerMap.put(headerKey, request.getHeader(headerKey));
            }

            jsonObject.put("headerMap", headerMap);

            jsonObject.put("remoteAddr", request.getRemoteAddr());

            jsonObject.put("remoteHost", request.getRemoteHost());

            return jsonObject.toJSONString();

        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw, true);
            e.printStackTrace(pw);
            return sw.getBuffer().toString();
        }

    }
}
