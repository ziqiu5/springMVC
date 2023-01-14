package com.atguigu.mvc.controller;

import com.atguigu.mvc.pojo.Employee;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * ClassName: ResponseMessageController
 * Package: com.atguigu.mvc.controller
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/8 - 12:36  12:36
 * @Version: v1.0
 */

/**
 * 该注解等于在本类中加载 Controller 注解 放入IOC容器中管理
 * 还加上了@ResonseBody 注解 将方法的返回值作为响应报文中的响应体传送数据给客户端浏览器
 */
@RestController
public class ResponseMessageController {

    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody() {
        return "hello,client,I am responseBody!";
    }

    @RequestMapping("/testResponseJavaPojo")
    @ResponseBody
    public Employee testResponseJavaPojo() {
        return new Employee(221, "ziqiu", "男", 21, new BigDecimal(17500));
    }


    @RequestMapping("/testAjaxRequestByVue")
    @ResponseBody
    public Employee testAjaxRequest(String username, String password) {
        System.out.println(username + ", " + password);
        return new Employee(221, "子秋", "男", 21, new BigDecimal(17500));
    }

    @RequestMapping("/testAjaxRequestByJquery")
    public Employee testAjaxRequestByJquery(@RequestBody String requestBody) {
        System.out.println("post请求体:" + requestBody);
        return new Employee(221, "子秋", "男", 21, new BigDecimal(17500));
    }
}
