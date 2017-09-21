package com.gradle.demo.service;

import com.gradle.demo.model.RespSector;
import com.gradle.demo.model.Student;
import com.gradle.demo.model.StudentRecord;

import java.util.List;

public interface RecordService {
    public StudentRecord save(StudentRecord studentRecord);
    public void deleteById(Long id);
    public List<StudentRecord> findAllByRespSector(RespSector respSector);
    public List<StudentRecord> findByStudent(String student);
    public void delete(Long id);
}
