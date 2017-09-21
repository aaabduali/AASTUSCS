package com.gradle.demo.service;

import com.gradle.demo.model.RespSector;
import com.gradle.demo.model.Student;
import com.gradle.demo.model.StudentRecord;
import com.gradle.demo.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordRepository recordRepository;
    @Override
    public StudentRecord save(StudentRecord studentRecord) {
        return recordRepository.save(studentRecord);
    }

    @Override
    public void deleteById(Long id) {
            recordRepository.deleteById(id);
    }

    @Override
    public List<StudentRecord> findAllByRespSector(RespSector respSector) {
            return recordRepository.findAllByRespSectors(respSector);
    }

    @Override
    public List<StudentRecord> findByStudent(String student) {
        return recordRepository.findByStudent(student);
    }

    @Override
    public void delete(Long id) {
        recordRepository.deleteById(id);
    }
}
