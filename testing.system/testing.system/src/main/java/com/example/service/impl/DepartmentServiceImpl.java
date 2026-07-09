package com.example.service.impl;

import com.example.dto.AccountDTO;
import com.example.dto.DepartmentDTO;
import com.example.entity.Account;
import com.example.entity.Department;
import com.example.form.DepartmentCreateOrUpdateForm;
import com.example.repository.IDepartmentRepository;
import com.example.service.IDepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IDepartmentRepository departmentRepository; // new

    @Override
    public List<DepartmentDTO> findAll() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map(dep -> modelMapper.map(dep, DepartmentDTO.class)).toList();
    }

    @Override
    public DepartmentDTO findById(Integer id) {
        Department department = departmentRepository.findById(id).orElse(null);
        DepartmentDTO dto = null;
        if (Objects.nonNull(department)) {
            dto = modelMapper.map(department, DepartmentDTO.class);
        }
        return dto;
    }

    @Override
    public void deleteById(Integer id) {
        departmentRepository.deleteById(id);

    }

    @Override
    public void create(DepartmentCreateOrUpdateForm form) {
        // kiem tra xem ten đa tồn tại chưa
//        if (departmentRepository.existsByNameAndIdNot(department.getName(), null)) {//where name = ?
//            throw new RuntimeException("Department already exists");
//        }
//        departmentRepository.save(department);

        if (departmentRepository.existsByNameAndIdNot(form.getName(), null)){
            throw new RuntimeException("Department already exists");

    }
            Department department = modelMapper.map(form, Department.class);

            departmentRepository.save(department);

    }

    @Override
    public void update(DepartmentCreateOrUpdateForm form, Integer id) {
        //  tìm department can update theo id
//        Department departmentUpdate = departmentRepository.findById(id).orElse(null);
//        if (Objects.isNull(departmentUpdate)) {
//            throw new RuntimeException("ID not found!");
//        } else {
//            if (departmentRepository.existsByNameAndIdNot(department.getName(), id)) {// where name = ? and id !=
//                throw new RuntimeException("Department already exists");
//            }
//
//            // lưu lại thông tin update
//            departmentUpdate.setName(department.getName());
//            departmentRepository.save(departmentUpdate);
//        }

        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        if (departmentRepository.existsByNameAndIdNot(form.getName(), id)) {
            throw new RuntimeException("Department already exists");
        }

        department.setName(form.getName());

        departmentRepository.save(department);

    }

    @Override
    public Department findByName(String name) {
        return departmentRepository.findByName(name);
    }
}
