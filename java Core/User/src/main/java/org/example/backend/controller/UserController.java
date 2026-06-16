package org.example.backend.controller;

import org.example.backend.service.IUserService;
import org.example.backend.service.UserService;
import org.example.entity.User;

import java.util.List;

public class UserController {
    private IUserService userService = new UserService();

    public List<User> findAll() {
        List<User> users = userService.findAll();
        return users;
    }

    public User findById(long id) {
        return userService.findById(id);
    }
    public boolean deleteId(long id) {
        return userService.deleteId(id);
    }
    public User login(String email, String password) {
        return userService.login(email, password);
    }
    public boolean create(String fullName, String email) {
        return userService.create(fullName,email);
    }
    public boolean checkExistEmail(String email) {
        return userService.checkExistEmail(email);
    }
            }