package org.example.backend.service;

import org.example.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    boolean checkExistEmail(String email);
    boolean create(String fullName, String email, java.sql.Date birth_date, int major_id);
    boolean updateMajorId(int studentId, int majorId);
    boolean deleteById(int id);
    List<Student> findByMajorName(String majorName);


}
