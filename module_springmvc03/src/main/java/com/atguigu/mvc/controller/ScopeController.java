package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * ClassName: ScopeController
 * Package: com.atguigu.mvc.controller
 * Description:
 *
 * @author ziqiu
 * @Create: 2023/1/5 - 21:48  21:48
 * @Version: v1.0
 */

@Controller
public class ScopeController {

    @RequestMapping("/testServletAPI")
    public String servletAPI(HttpServletRequest req){
        req.setAttribute("requestScope", "hello,servletAPI");
        return "target";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("requestScope", "hello,ModelAndView");
        modelAndView.setViewName("target");
        return modelAndView;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("requestScope", "hello,model");
        return "target";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map){
        map.put("requestScope", "hello,map");
        return "target";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("requestScope",  "hello,modelMap");
        return "target";
    }

    @RequestMapping("/testSession")
    public String testSession(HttpSession session){
        session.setAttribute("sessionScope", "hello,Session!");
        return "target";
    }

    @RequestMapping("/testSession2")
    public String testSession2(HttpServletRequest req){
        req.getSession().setAttribute("sessionScope", "hello,Session!");
        return "target";
    }

    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session){
        ServletContext application = session.getServletContext();
        application.setAttribute("applicationScope", "hello,application!");
        return "target";
    }



}
