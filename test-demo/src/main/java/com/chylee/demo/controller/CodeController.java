package com.chylee.demo.controller;

import com.chylee.demo.filter.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CodeController {
    @GetMapping("xx")
    public Response xx(String code) {
        Response response = new Response();
        response.setData(code);
        return response;
    }

    @GetMapping("yy")
    public Response yy(HttpServletRequest request) {
        System.out.println(request.getSession().getId());
        Response response = new Response();
        response.setData((String) request.getSession().getAttribute("test_hahah"));
        return response;
    }
}
