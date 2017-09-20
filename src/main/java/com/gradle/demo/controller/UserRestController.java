package com.gradle.demo.controller;

import com.gradle.demo.model.Users;
import com.gradle.demo.service.UserService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    private UserService userService;
    @RequestMapping(value = "/users/table",method = RequestMethod.GET)
    public List<Users> findUsers()
    {
        return userService.findUsers();

    }

}
