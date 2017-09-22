package com.gradle.demo.service;

import com.gradle.demo.model.RespSector;
import com.gradle.demo.repository.RespSectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespSectorServiceImpl implements RespSectorService {
    @Autowired
    private RespSectorRepository respSectorRepository;
    @Override
    public RespSector findByName(String name) {

        return respSectorRepository.findByName(name);
    }

    @Override
    public List<RespSector> findAll() {
      return respSectorRepository.findAll();
    }
}
