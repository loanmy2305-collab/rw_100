package org.example.backend.service.impl;

import org.example.backend.repository.IDepartmentRepository;
import org.example.backend.repository.impl.DepartmentRepositoryImpl;
import org.example.backend.service.IDepartmentService;
import org.example.dto.ImportError;
import org.example.dto.context.DepartmentContext;
import org.example.dto.csv.DepartmentCsv;
import org.example.entity.Department;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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



//    @Override
//    public String importDepartmentFromCSV(String pathName) {
//        // check file c tồn tại không
//        File file = new File(pathName);
//        if (!file.exists()) {
//            return "file không tồn tai";
//        }
//        // dọc dữ liệu từ file và dưa dữ lệu cho repository để lưu vào DB
//        if (!pathName.endsWith(".csv")) {
//            return "dịnh dạng file không đuúng";
//        }
////          C:\Users\LOAN\Documents\rw_100\csv\input_department.csv
////         FileReader:là 1 đói tượng dùngdể đọc file ,đọc từng kí tự
////         BuferrdReader: hỗ trợ đọc theo từng dòng
//
//
//        List<ImportError> importErrors = new ArrayList<>();
//        List<Department> departments = new ArrayList<>();// chua ds department se dc them moi
//
//        Map<String, Department> mapByName = departmentRepository.mapByName();
//        try (BufferedReader br = new BufferedReader(new FileReader(pathName))) {
//            String line = br.readLine();// lay dòng dau tien, bo no di
//            while ((line = br.readLine()) != null) {
//                // validation
//                this.validation(line, mapByName, departments, importErrors);
//            }
//            //  luu vao DB
//            departmentRepository.createListDepartment(departments);
//
//            // xuất ra file lỗi -ghi dữ liệu ra file
//            String pathError = "\\Users\\LOAN\\Documents\\rw_100\\csv\\output_error_department.csv";
//            this.exportFileCSV(importErrors, pathError);
//        } catch (Exception e) {

    /// /            throw new RuntimeException(e);
//        }
//        //TH1: ImportErrors.size= 0 ko có lỗi gì -> "import thanh công"
//        //TH2:ImportErrors.size != 0 , department.size = 0 ->"toàn bộ file lỗi,
//        //                                  ->import k thành công,  đã xuất file lỗi csv\ouput_error_department.csv"
//        //TH3: ImportErrors.size != 0 , department.size != 0 -> import được 1 vài dep
//        //                             ->   import ? thành công và xuất ? row ra file lỗi csv\ouput_error_department.csv"
//
//        String message = "";
//        if (importErrors.isEmpty()) {
//            message = "Import thành công";
//        }
//        if (departments.isEmpty()) {
//            message = "Import k thành công , đã xuất file lỗi csv\\ouput_error_department.csv";
//        }
//        if (!importErrors.isEmpty() && !departments.isEmpty()) {
//            message = "Import thành công" + departments.size() + "phòng ban, " +
//                    "đã xuất file lỗi csv\\ouput_error_department.csv";
//        }
//        return message;
//    }
    public void exportFileCSV(List<ImportError> importErrors, String pathError) {
        if (!importErrors.isEmpty()) {
            try {
                //   String pathError = "\\Users\\LOAN\\Documents\\rw_100\\csv\\output_error_department.csv";
                BufferedWriter bw = new BufferedWriter(new FileWriter(pathError));
                bw.write("department_name, error_mesage");
                bw.newLine();
                for (ImportError errors : importErrors) {
                    String ln = errors.getCsv() + "," + String.join("|", errors.getMessage());
                    bw.write(ln);
                    bw.newLine();
                }
                bw.flush();
            } catch (Exception e) {
//            e.printStackTrace();
            }
        }
    }

    public void validation(String line, Map<String, Department> mapByName,
                           List<Department> departments, List<ImportError> importErrors) {
        List<String> errors = new ArrayList<>();// lưu lại ca lỗi cuủa row này
        String[] fields = line.split(",");
        String departmentName = fields[0];
        // validation

        if (Objects.isNull(departmentName) || departmentName.trim().isEmpty()) {
            // tên phòng ban không được để troosng
            errors.add(" tên phòng ban khoong được để trống");
        } else if (departmentName.length() > 100) {
            errors.add("tên phòng ban không được dài quá 100 kí tự");
        } else if (mapByName.get(departmentName) != null) {
            errors.add("tên phòng ban đã ồn tại");
        }
        if (errors.isEmpty()) {
            Department dep = new Department(departmentName);
            departments.add(dep);
            // check tồn tại cho file có nhiều gtri trùng lặp
            mapByName.put(departmentName, dep);
        } else {
            // theem line lỗi + ds lỗi liên quan vào list để xuất file lỗi
            ImportError importError = new ImportError(line, errors);
            importErrors.add(importError);
        }
    }

    @Override
    public void validation(String line, DepartmentContext context, List<Department> etities, List<ImportError<DepartmentCsv>> importErrors) {

        List<String> errors = new ArrayList<>();// lưu lại ca lỗi cuủa row này
        String[] fields = line.split(",");
        String departmentName = fields[0];
        // validation

        if (Objects.isNull(departmentName) || departmentName.trim().isEmpty()) {
            // tên phòng ban không được để troosng
            errors.add(" tên phòng ban khoong được để trống");
        } else if (departmentName.length() > 100) {
            errors.add("tên phòng ban không được dài quá 100 kí tự");
        } else if (context.getMapByDepartmentName().get(departmentName) != null) {
            errors.add("tên phòng ban đã ồn tại");
        }
        if (errors.isEmpty()) {
            Department dep = new Department(departmentName);
            etities.add(dep);
            // check tồn tại cho file có nhiều gtri trùng lặp
            context.getMapByDepartmentName().put(departmentName, dep);
        } else {
            // theem line lỗi + ds lỗi liên quan vào list để xuất file lỗi
            DepartmentCsv csv = new DepartmentCsv(departmentName);
            ImportError importError = new ImportError(csv, errors);
            importErrors.add(importError);
        }
    }

    @Override
    public void saveAll(List<Department> entities) {
        departmentRepository.createListDepartment(entities);
    }

    @Override
    public void exportFileError(List<ImportError<DepartmentCsv>> importErrors, String pathError) {

        if (!importErrors.isEmpty()) {
            try {
                //   String pathError = "\\Users\\LOAN\\Documents\\rw_100\\csv\\output_error_department.csv";
                BufferedWriter bw = new BufferedWriter(new FileWriter(pathError));
                bw.write("department_name, error_mesage");
                bw.newLine();
                for (ImportError errors : importErrors) {
                    String ln = errors.getCsv().toString() + "," + String.join("|", errors.getMessage());
                    bw.write(ln);
                    bw.newLine();
                }
                bw.flush();
            } catch (Exception e) {
//            e.printStackTrace();
            }
        }
    }

    @Override
    public String importDepartmentFromCSV(String pathName) {
        String pathError = "C:\\Users\\LOAN\\OneDrive\\Documents\\rw_100\\csv\\output_error_department.csv";
        //lap ra map -> đưa map vào departmentcontext
        Map<String, Department> mapByName = departmentRepository.mapByName();
        DepartmentContext context = new DepartmentContext(mapByName);
        String message = this.importFileCSV(pathName, context, pathError);
        return message;
    }
}
