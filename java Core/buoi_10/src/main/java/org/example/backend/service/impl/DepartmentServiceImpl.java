package org.example.backend.service.impl;

import org.example.backend.repository.IDepartmentRepository;
import org.example.backend.repository.impl.DepartmentRepositoryImpl;
import org.example.backend.service.IDepartmentService;
import org.example.entity.Department;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
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

    @Override
    public String importDepartmentFromCSV(String pathName) {
        // dọc dữ liệu từ file và dưa dữ lệu cho repository để lưu vào DB
        if (!pathName.endsWith(".csv")) {
            return "dịnh dạng file không đuúng";
        }
//         FileReader:là 1 đói tượng dùngdể đọc file ,đọc từng kí tự
//         BuferrdReader: hỗ trợ đọc theo từng dòng
//        int countS = 0;
//        int countF = 0;
//
//        try (BufferedReader br = new BufferedReader(new FileReader(pathName))) {
//            String line = br.readLine();// lấy dòng đầu tiên, bỏ nó
//            while ((line = br.readLine()) != null) {
//                String[] fields = line.split(",");
//                String departmentName = fields[0];
//                boolean checkInsert = departmentRepository.insert(departmentName);
//                if (checkInsert) {
//                    countS++;
//                } else {
//                    countF++;
//                }
//            }
//        } catch (Exception e) {
//            //   e.printStackTrace();
//        }
//        return "Import thành công " + countS + "department, Import thất bại " + countF + "department";

       boolean checkCreate = false;
        List<Department> departments = new ArrayList<>();// chua ds department se dc them moi
        try (BufferedReader br = new BufferedReader(new FileReader(pathName))) {
            String line = br.readLine();// lay dòng dau tien, bo no di
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                String departmentName = fields[0];
                // validation
                Department dep = new Department(departmentName);
                departments.add(dep);
            }

            //  luu vao DB
            checkCreate = departmentRepository.createListDepartment(departments);

            // xuat ra file loi

        } catch (Exception e) {
//            e.printStackTrace();
        }
        return "Import thành công ";
    }


}



