package com.example.service;

import com.example.dto.DepartmentDTO;
import com.example.entity.Department;
import com.example.form.DepartmentCreateOrUpdateForm;

import java.util.List;

public interface IDepartmentService {
    List<DepartmentDTO> findAll();

    DepartmentDTO findById( Integer id);

    void deleteById(Integer id);

    void create(DepartmentCreateOrUpdateForm department);

    void update(DepartmentCreateOrUpdateForm department , Integer id);

    Department findByName(String name);

}
