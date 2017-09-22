package com.gradle.demo.service;

import com.gradle.demo.model.RespSector;

import java.util.List;

public interface RespSectorService {
    public RespSector findByName(String name);
    public List<RespSector> findAll();
}
