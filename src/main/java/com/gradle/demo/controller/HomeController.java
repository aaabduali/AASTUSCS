package com.gradle.demo.controller;

import com.gradle.demo.model.Users;
import com.gradle.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
@Autowired
private UserService userService;
    @RequestMapping("/")
    public ModelAndView home()
    {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("title","Dashboard");
        modelAndView.setViewName("dashboard");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user=userService.findByUsername(auth.getName());
        modelAndView.addObject("fullname",user.getFirstName()+" "+user.getLastName());
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
