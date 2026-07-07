package com.example.controller;

import com.example.entity.Account;

import com.example.entity.Position;
import com.example.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;// =new

    //lấy ds acc
    @GetMapping
    public ResponseEntity<List<Account>> findAll() {
        List<Account> accounts = accountService.findAll();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    // lấy ra chức vụ  theo id -- khóa chính
    @GetMapping("/{idSearch}") // http://localhost:8080/api/v1/position/13
    public ResponseEntity<Account> findById(@PathVariable(name = "idSearch") Integer id) {
        Account account = accountService.findById(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    // xóa theo id
    //
    @DeleteMapping("/{idDelete}") // http://localhost:8080/api/v1/department/13
    public ResponseEntity<String> deleteById(@PathVariable(name = "idDelete") Integer id) {
        accountService.deleteById(id);
        return new ResponseEntity<>("xóa thành công", HttpStatus.OK);
    }

    // tạo mới 1 pos
    @PostMapping
    public ResponseEntity<String> create(@RequestBody Account account) {
        accountService.create( account);
        return new ResponseEntity<>("Tạo mới thành công", HttpStatus.OK);
    }

    // update theo id
    @PutMapping("/{idUpdate}")
    public ResponseEntity<String> update(@RequestBody Account account,@PathVariable(name = "idUpdate") Integer id) {
        accountService.update(account,id);
        return new ResponseEntity<>("update thành công", HttpStatus.OK);
    }
}
