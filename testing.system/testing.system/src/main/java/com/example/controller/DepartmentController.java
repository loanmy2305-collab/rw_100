package com.example.controller;

import com.example.dto.DepartmentDTO;
import com.example.entity.Department;
import com.example.form.DepartmentCreateOrUpdateForm;
import com.example.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/departments")
@CrossOrigin("*")//http://127.0.0.1:5500/
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;// = new ();

    // lấy ra ds department
    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> findAll() {
        return new ResponseEntity<>(departmentService.findAll(), HttpStatus.OK);
    }

    //lay ra thong tin department theo id  - khóa chính
    @GetMapping("/{idSearch}")// http://localhost:8080/api/v1/departments/13
    public ResponseEntity<DepartmentDTO> findById(@PathVariable(name = "idSearch") Integer id) {
        return new ResponseEntity<>(departmentService.findById(id), HttpStatus.OK);
    }

    // tìm kiếm theo departmentName
    @GetMapping("/search")// http://localhost:8080/api/v1/departments/search?name=Sale&description=abc
    public ResponseEntity<Department> findByName(@RequestParam(name = "name") String name) {
        Department department = departmentService.findByName(name);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    // xóa theo id
    @DeleteMapping("/{idDelete}")// http://localhost:8080/api/v1/departments/13
    public ResponseEntity<String> deleteById(@PathVariable(name = "idDelete") Integer id) {
        departmentService.deleteById(id);
        return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
    }

    // tao moi 1 department
    @PostMapping
    public ResponseEntity<String> create(@RequestBody DepartmentCreateOrUpdateForm form) {
        departmentService.create(form);
        return new ResponseEntity<>("Tạo mới thành công", HttpStatus.CREATED);
    }

    // update theo id
    @PutMapping("/{idUpdate}")
    public ResponseEntity<String> update(@RequestBody DepartmentCreateOrUpdateForm form,
                                         @PathVariable(name = "idUpdate") Integer id) {
        departmentService.update(form, id);
        return new ResponseEntity<>("Update thành công", HttpStatus.OK);
    }
}

