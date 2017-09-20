package com.gradle.demo.controller;

import com.gradle.demo.model.RespSector;
import com.gradle.demo.model.StudentRecord;
import com.gradle.demo.model.Users;
import com.gradle.demo.service.RecordService;
import com.gradle.demo.service.RespSectorService;
import com.gradle.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecordRestController {
    @Autowired
    private RecordService recordService;
    @Autowired
    private RespSectorService respSectorService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/records/table",method = RequestMethod.GET)
    public List<StudentRecord> findRecords(RespSector respSector1)
    {
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        Users user=userService.findByUsername(auth.getName());
        RespSector respSector=respSectorService.findByName(user.getRespSector().getName());

        return recordService.findAllByRespSector(respSector);

    }

    @RequestMapping(value="/request/status",method = RequestMethod.POST,produces = "application/json")
    public List<StudentRecord> findById(String student)
    {
        return recordService.findByStudent(student);
    }

}
