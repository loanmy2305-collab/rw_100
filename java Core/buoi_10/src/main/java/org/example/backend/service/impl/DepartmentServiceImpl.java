package org.example.backend.service.impl;

import org.example.backend.repository.IDepartmentRepository;
import org.example.backend.repository.impl.DepartmentRepositoryImpl;
import org.example.backend.service.IDepartmentService;
import org.example.entity.Department;

import java.util.List;

public class DepartmentServiceImpl implements IDepartmentService {
    // khơởi tạo đối tượng departmentRepository
    private IDepartmentRepository departmentRepository = new DepartmentRepositoryImpl();

    @Override
    public List<Department> findAll() {
        // lấy ra ds department từ repository
        List<Department> departments = departmentRepository.findAll();
        return departments;
    }

    @Override
    public boolean insert(String name) {
        boolean check = departmentRepository.insert(name);
        return check;
    }

    @Override
    public boolean delete(int id) {
        boolean check = departmentRepository.delete(id);
        return check;
    }

    @Override
    public boolean update(int id, String updateName) {
        boolean check = departmentRepository.update(id, updateName);
        return check;
    }

    @Override
    public boolean checkExistNameAndIdNot(String name, Integer id) {
        return departmentRepository.checkExistNameAndIdNot(name, id);
    }

    @Override
    public boolean checkExistID(Integer id) {
        return departmentRepository.checkExistID(id);
    }
}
