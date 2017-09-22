package com.gradle.demo.repository;

import com.gradle.demo.model.RespSector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespSectorRepository extends JpaRepository<RespSector,Integer>{
    RespSector findByName(String name);
    List<RespSector> findAll();
}
