package com.gradle.demo.controller;

import com.gradle.demo.model.Users;
import com.gradle.demo.service.RespSectorService;
import com.gradle.demo.service.RoleService;
import com.gradle.demo.service.UserService;
import com.gradle.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RespSectorService respSectorService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/user")
    public ModelAndView user()
    {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("title","User Accounts");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user=userService.findByUsername(auth.getName());
        modelAndView.addObject("fullname",user.getFirstName()+" "+user.getLastName());
        modelAndView.setViewName("user/list");
                return modelAndView;
    }
    @RequestMapping(value = "/user/form",method = RequestMethod.GET)
    public ModelAndView newUser()
    {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("title","New Account");
        modelAndView.addObject("resp",respSectorService.findAll());
        modelAndView.addObject("role",roleService.findAll());
        modelAndView.addObject("user",new Users());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user=userService.findByUsername(auth.getName());
        modelAndView.addObject("fullname",user.getFirstName()+" "+user.getLastName());
        modelAndView.setViewName("user/form");
        return modelAndView;
    }
    @RequestMapping(value = "user/form",method = RequestMethod.POST)
    public String newRecord(@Valid Users users, BindingResult bindingResult, @RequestParam("role") Long role, RedirectAttributes model){

            userService.save(users);

            userService.addRole(users.getId(),role.intValue());
            model.addFlashAttribute("error", "success");
            return "redirect:/user/";

    }

}
