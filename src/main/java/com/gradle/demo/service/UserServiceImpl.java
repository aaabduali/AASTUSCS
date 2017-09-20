package com.gradle.demo.service;

import com.gradle.demo.model.CustomUserDetails;
import com.gradle.demo.model.Users;
import com.gradle.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService,UserService {

    @Autowired
    private UserRepository userRepository;

    @Override

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> userOptional = userRepository.findByUsername(username);
        System.out.println("username = [" + username + "]");
        userOptional
                .orElseThrow(() -> new UsernameNotFoundException("username not found"));
        CustomUserDetails customUserDetails = userOptional
                .map(users -> {
                    return new CustomUserDetails(users);}).get();
        return customUserDetails;
    }


    @Override
    public Users findByUsername(String username) {
        return userRepository.findUsersByUsername(username);
    }

    @Override
    public Users save(Users users) {

        users.setAttempt(0);
        users.setActive(true);
        users.setExpired(false);
        users.setLocked(false);

        users.setUsername(users.getFirstName().substring(0,2)+users.getLastName());
        users.setPassword(users.getUsername().substring(0,2)+users.getPhone().substring(0,3)+users.getUsername().substring(2,3));
        return userRepository.save(users);
    }

    @Override
    public Users edit(Users users) {
        return userRepository.save(users);
    }

    @Override
    public List<Users> findUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users findById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void addRole(int users, int role) {
        userRepository.addUserRole(users,role);
    }
}
