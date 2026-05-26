package org.example.backend.repository;

import org.example.entity.Department;

import java.util.List;
import java.util.Map;

public interface IDepartmentRepository {
    List<Department> findAll();
    boolean insert(String name);
    boolean delete(int id);
    boolean update(int id, String updateName);
    boolean checkExistID(Integer id);
    boolean checkExistNameAndIdNot(String name, Integer id);
    boolean createListDepartment(List<Department> list);

    Map<String, Department> mapByName();
}

