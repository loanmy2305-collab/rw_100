package org.example.backend.service;

import org.example.dto.context.DepartmentContext;
import org.example.dto.csv.DepartmentCsv;
import org.example.entity.Department;

import java.util.List;

public interface IDepartmentService extends  ImportFileCSV<DepartmentContext,Department, DepartmentCsv> {
    List<Department> findAll();
    boolean insert(String name);
    boolean delete(int id);
    boolean update(int id, String updateName);

    boolean checkExistNameAndIdNot(String name, Integer id);
    boolean checkExistID(Integer id);

    String importDepartmentFromCSV(String pathName);

}