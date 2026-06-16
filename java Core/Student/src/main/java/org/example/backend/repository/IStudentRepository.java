package org.example.backend.repository;

import org.example.entity.Student;


import java.sql.Date;
import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
    boolean checkExistEmail(String email);
    boolean create(String fullName, String email, Date birth_date, int major_id);
    boolean updateMajorId(int studentId, int majorId);
    boolean deleteById(int id);
    List<Student> findByMajorName(String majorName);




}
