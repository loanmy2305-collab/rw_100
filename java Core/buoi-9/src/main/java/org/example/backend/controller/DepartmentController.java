package org.example.backend.controller;

import org.example.backend.service.IDepartmentService;
import org.example.backend.service.impl.DepartmentServiceImpl;
import org.example.entity.Department;

import java.util.List;

public class DepartmentController {
    // khởi tạo DepartmentService
    private IDepartmentService departmentService = new DepartmentServiceImpl();

    public List<Department> findAll(){
        // lấy ds từu service
        List<Department> departments = departmentService.findAll();
        return departments;
    }

    public boolean insert(String name){
        boolean check = departmentService.insert(name);
        return check;
    }

    public boolean delete(int id){
        boolean check = departmentService.delete(id);
        return check;
    }

    public boolean update(int id, String updatename){
        boolean check = departmentService.update(id, updatename);
        return check;
    }

}
