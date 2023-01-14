package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: ViewController
 * Package: com.atguigu.mvc.controller
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/6 - 15:38  15:38
 * @Version: v1.0
 */

@Controller
public class ViewController {

    @RequestMapping("/target")
    public String toTarget(){
        return "target";
    }


    @RequestMapping("/testForwardView")
    public String testForwardView(){
        return "forward:/target";
    }

    @RequestMapping("/testRedirectView")
    public String testRedirectView(){
        return "redirect:/target";
    }


}
