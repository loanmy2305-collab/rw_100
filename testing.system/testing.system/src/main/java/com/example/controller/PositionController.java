package com.example.controller;


import com.example.dto.PositionDTO;
import com.example.entity.Position;
import com.example.form.PositionCreateOrUpdateForm;
import com.example.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/positions")
@CrossOrigin("*")//http://127.0.0.1:5500/
public class PositionController {

    @Autowired
    private IPositionService positionService; // =new

    //lấy ds position
    @GetMapping
    public ResponseEntity<List<PositionDTO>> findAll() {
        return new ResponseEntity<>(positionService.findAll(), HttpStatus.OK);
    }

    // lấy ra chức vụ  theo id -- khóa chính
    @GetMapping("/{idSearch}") // http://localhost:8080/api/v1/position/13
    public ResponseEntity<PositionDTO> findById(@PathVariable(name = "idSearch") Integer id) {
        return new ResponseEntity<>(positionService.findById(id), HttpStatus.OK);
    }

    // xóa theo id
    //
    @DeleteMapping("/{idDelete}") // http://localhost:8080/api/v1/department/13
    public ResponseEntity<String> deleteById(@PathVariable(name = "idDelete") Integer id) {
        positionService.deleteById(id);
        return new ResponseEntity<>("xóa thành công", HttpStatus.OK);
    }

    // tạo mới 1 pos
    @PostMapping
    public ResponseEntity<String> create(@RequestBody PositionCreateOrUpdateForm form) {
        positionService.create( form);
        return new ResponseEntity<>("Tạo mới thành công", HttpStatus.OK);
    }

    // update theo id
    @PutMapping("/{idUpdate}")
    public ResponseEntity<String> update(@RequestBody PositionCreateOrUpdateForm form,@PathVariable(name = "idUpdate") Integer id) {
        positionService.update(form,id);
        return new ResponseEntity<>("update thành công", HttpStatus.OK);
    }
}
