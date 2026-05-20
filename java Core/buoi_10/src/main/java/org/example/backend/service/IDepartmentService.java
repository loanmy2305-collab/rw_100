package org.example.backend.service;

import org.example.entity.Department;

import java.util.List;

public interface IDepartmentService {
    List<Department> findAll();
    boolean insert(String name);
    boolean delete(int id);
    boolean update(int id, String updateName);

    boolean checkExistNameAndIdNot(String name, Integer id);
    boolean checkExistID(Integer id);
}
