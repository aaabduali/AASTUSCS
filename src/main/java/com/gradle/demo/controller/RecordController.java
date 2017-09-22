package com.gradle.demo.controller;

import com.gradle.demo.model.Student;
import com.gradle.demo.model.StudentRecord;
import com.gradle.demo.model.Users;
import com.gradle.demo.service.RecordService;
import com.gradle.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.xml.ws.Action;

@Controller
public class RecordController {
    @Autowired
    private RecordService recordService;

    @Autowired
    private UserService userService;
    @RequestMapping("/records")
    public ModelAndView records()
    {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("title","Records");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user=userService.findByUsername(auth.getName());
        modelAndView.addObject("fullname",user.getFirstName()+" "+user.getLastName());
        modelAndView.setViewName("records/list");
        return modelAndView;
    }
    @RequestMapping(value = "/records/form",method = RequestMethod.GET)
    public ModelAndView newRecords()
    {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("record",new StudentRecord());
        modelAndView.addObject("title","New Records");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user=userService.findByUsername(auth.getName());
        modelAndView.addObject("fullname",user.getFirstName()+" "+user.getLastName());
        modelAndView.setViewName("records/form");
        return modelAndView;
    }
    
    @RequestMapping(value = "records/form",method = RequestMethod.POST)
    public String newRecord(@Valid StudentRecord studentRecord, BindingResult bindingResult, RedirectAttributes model){


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user=userService.findByUsername(auth.getName());
        studentRecord.setRespSectors(user.getRespSector());
        recordService.save(studentRecord);
       model.addFlashAttribute("error", "success");
        return "redirect:/records/";

    }
    @GetMapping("records/delete/{id}")
    public String delete(@PathVariable Long id) {
        recordService.deleteById(id);
        return "redirect:/records";
}
}
