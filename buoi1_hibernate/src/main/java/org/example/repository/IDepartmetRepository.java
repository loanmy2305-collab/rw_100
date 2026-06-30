package org.example.repository;

import org.example.entity.Department;

import java.util.List;

public interface IDepartmetRepository {
    List<Department> findAll();
    Department findById(Integer id);
    void create(String name);
    void update(String updateName, Integer id);
}
