package com.gradle.demo.controller;

import com.gradle.demo.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public ModelAndView home()
    {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("title","Dashboard");
        modelAndView.setViewName("dashboard");

        return modelAndView;
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login()
    {
        Users users=new Users();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("users",users);
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
