package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: testController
 * Package: com.atguigu.mvc.controller
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/7 - 14:23  14:23
 * @Version: v1.0
 */

@Controller
public class testController {

    @RequestMapping("/target")
    public String testController(){
        return "target";
    }
}
