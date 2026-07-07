package com.example.controller;


import com.example.entity.Position;
import com.example.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/position")
public class PositionController {

    @Autowired
    private IPositionService positionService; // =new

    //lấy ds position
    @GetMapping
    public ResponseEntity<List<Position>> findAll() {
        List<Position> positions = positionService.findAll();
        return new ResponseEntity<>(positions, HttpStatus.OK);
    }

    // lấy ra chức vụ  theo id -- khóa chính
    @GetMapping("/{idSearch}") // http://localhost:8080/api/v1/position/13
    public ResponseEntity<Position> findById(@PathVariable(name = "idSearch") Integer id) {
        Position position = positionService.findById(id);
        return new ResponseEntity<>(position, HttpStatus.OK);
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
    public ResponseEntity<String> create(@RequestBody Position position) {
        positionService.create( position);
        return new ResponseEntity<>("Tạo mới thành công", HttpStatus.OK);
    }

    // update theo id
    @PutMapping("/{idUpdate}")
    public ResponseEntity<String> update(@RequestBody Position position,@PathVariable(name = "idUpdate") Integer id) {
        positionService.update(position,id);
        return new ResponseEntity<>("update thành công", HttpStatus.OK);
    }
}
