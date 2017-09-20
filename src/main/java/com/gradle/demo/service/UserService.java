package com.gradle.demo.service;

import com.gradle.demo.model.Users;

import java.util.List;

public interface UserService {
    public Users findByUsername(String username);
    public Users save(Users users);
    public Users edit (Users users);
    public List<Users> findUsers();
    public Users findById(int id);
    public void addRole(int users,int role);
}
