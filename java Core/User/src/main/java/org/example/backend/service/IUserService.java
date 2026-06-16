package org.example.backend.service;

import org.example.entity.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User findById(long id);
    boolean deleteId(long id);
    User login(String email, String password);
    boolean create(String fullName, String email);
    boolean checkExistEmail(String email);
}
