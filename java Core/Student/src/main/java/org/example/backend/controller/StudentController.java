package org.example.backend.controller;

import org.example.backend.service.IStudentService;
import org.example.backend.service.impl.StudentServiceImpl;
import org.example.entity.Student;

import java.sql.Date;
import java.util.List;

public class StudentController {
    private IStudentService studentService = new StudentServiceImpl();

    public List<Student> findAll() {
        List<Student> students = studentService.findAll();
        return students;
    }

    public boolean checkExistEmail(String email) {
        return studentService.checkExistEmail(email);
    }

    public boolean create(String fullName, String email, Date birth_date, int major_id) {
        return  studentService.create(fullName,email,birth_date,major_id);
    }

    public boolean updateMajorId(int studentId, int majorId) {
        return  studentService.updateMajorId(studentId,majorId);
    }
    public boolean deleteById(int id) {
        return  studentService.deleteById(id);
    }

    public List<Student> findByMajorName(String majorName) {
        List<Student> students = studentService.findByMajorName(majorName);
        return students;
    }

}

