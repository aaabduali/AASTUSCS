package com.gradle.demo.controller;

import com.gradle.demo.model.Users;
import com.gradle.demo.service.UserService;
import com.gradle.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public ModelAndView user()
    {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("title","User Accounts");
        modelAndView.setViewName("user/list");
                return modelAndView;
    }
    @RequestMapping(value = "/user/form",method = RequestMethod.GET)
    public ModelAndView newUser()
    {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("title","New Account");
        modelAndView.addObject("user",new Users());
        modelAndView.setViewName("user/form");
        return modelAndView;
    }
    @RequestMapping(value = "user/form",method = RequestMethod.POST)
    public String newRecord(@Valid Users users, BindingResult bindingResult, RedirectAttributes model){

            userService.save(users);

            userService.addRole(users.getId(),1);
            model.addFlashAttribute("error", "success");
            return "redirect:/user/";

    }

}
