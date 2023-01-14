package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ClassName: IndexController
 * Package: com.atguigu.mvc.controller
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/5 - 20:28  20:28
 * @Version: v1.0
 */

@Controller
public class IndexController {

    @RequestMapping({"/", "/index"})
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }


}
