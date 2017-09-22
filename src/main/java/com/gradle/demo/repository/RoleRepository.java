package com.gradle.demo.repository;

import com.gradle.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer>{
    List<Role> findAllBy();

}
