package com.atguigu.mvc.controller;

import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName: HttpMessageController
 * Package: com.atguigu.mvc.controller
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/7 - 23:08  23:08
 * @Version: v1.0
 */

@Controller
public class HttpMessageController {

    @RequestMapping(value = "/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody) {
        System.out.println(requestBody);
        return "target";
    }

    @RequestMapping(value = "/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity, HttpServletRequest req) {
        System.out.println("Referer:" + req.getHeader("Referer"));
        System.out.println("请求头" + requestEntity.getHeaders());
        System.out.println("请求体(存放post请求参数):" + requestEntity.getBody());
        return "target";
    }

    @RequestMapping("/testExceptionResolver")
    public String testExceptionResolver() {
        System.out.println(1 / 0);
        return "target";
    }



}
