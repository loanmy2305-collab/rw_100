package org.example.backend.service;

import org.example.backend.repository.IUserRepository;
import org.example.backend.repository.UserRepository;
import org.example.entity.User;

import java.util.List;

public class UserService implements IUserService{
    private IUserRepository userRepository = new UserRepository();
    @Override
    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean deleteId(long id) {
        return userRepository.deleteId(id);
    }

    @Override
    public User login(String email, String password) {
        return userRepository.login(email,password);
    }

    @Override
    public boolean create(String fullName, String email) {
        return userRepository.create(fullName,email);
    }

    @Override
    public boolean checkExistEmail(String email) {
        return userRepository.checkExistEmail(email);
    }
}
