package com.example.service.impl;

import com.example.entity.Department;
import com.example.repository.IDepartmentRepository;
import com.example.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private IDepartmentRepository departmentRepository; // new

    @Override
    public List<Department> findAll() {
        List<Department> departments = departmentRepository.findAll();
        return departments;
    }

    @Override
    public Department findById(Integer id) {
        Department department = departmentRepository.findById(id).orElse(null);
        // orElse(null) :
        return department;
    }

    @Override
    public void deleteById(Integer id) {
        departmentRepository.deleteById(id);

    }

    @Override
    public void create(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void update(Department department, Integer id) {
        // tìm dep câần update theo id
        Department departmentUpdate = departmentRepository.findById(id).orElse(null);
        if (Objects.isNull(departmentUpdate)){
            throw new RuntimeException("ID not found!");
        }else {
            //lưu lại thông tin update
            departmentUpdate.setName(department.getName());
            departmentRepository.save(departmentUpdate);
        }

    }
}
