package com.example.controller;

import com.example.entity.Department;
import com.example.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/department")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService; // =new

    // lấy ra ds department
    @GetMapping
    public ResponseEntity<List<Department>> findAll() {
        List<Department> departments = departmentService.findAll();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    // lấy ra thông tin department theo id -- khóa chính
    @GetMapping("/{idSearch}") // http://localhost:8080/api/v1/department/13
    public ResponseEntity<Department> findById(@PathVariable(name = "idSearch") Integer id) {
        Department department = departmentService.findById(id);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    // xóa theo id
    //
    @DeleteMapping("/{idDelete}") // http://localhost:8080/api/v1/department/13
    public ResponseEntity<String> deleteById(@PathVariable(name = "idDelete") Integer id) {
        departmentService.deleteById(id);
        return new ResponseEntity<>("xóa thành công", HttpStatus.OK);
    }

    // tạo mới 1 dep
    @PostMapping
    public ResponseEntity<String> create(@RequestBody Department department) {
        departmentService.create(department);
        return new ResponseEntity<>("Tạo mới thành công", HttpStatus.OK);
    }

    // update theo id
    @PutMapping("/{idUpdate}")
    public ResponseEntity<String> update(@RequestBody Department department,@PathVariable(name = "idUpdate") Integer id) {
        departmentService.update(department,id);
        return new ResponseEntity<>("update thành công", HttpStatus.OK);
    }

}
