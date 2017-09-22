package com.gradle.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RequestController {
    @RequestMapping("/check")
    public ModelAndView request()
    {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("/check");
        return modelAndView;
    }
}
