package org.example.backend.service.impl;

import org.example.backend.repository.IStudentRepository;
import org.example.backend.repository.impl.StudentRepositoryImpl;
import org.example.backend.service.IStudentService;
import org.example.entity.Student;

import java.sql.Date;
import java.util.List;

public class StudentServiceImpl implements IStudentService {
    private IStudentRepository studentRepository = new StudentRepositoryImpl();

    @Override
    public List<Student> findAll() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    @Override
    public boolean checkExistEmail(String email) {
         return studentRepository.checkExistEmail(email);
    }

    @Override
    public boolean create(String fullName, String email, Date birth_date, int major_id) {
        return  studentRepository.create(fullName,email,birth_date,major_id);
    }

    @Override
    public boolean updateMajorId(int studentId, int majorId) {
        return  studentRepository.updateMajorId(studentId,majorId);
    }

    @Override
    public boolean deleteById(int id) {
        return  studentRepository.deleteById(id);
    }

    @Override
    public List<Student> findByMajorName(String majorName) {
        List<Student> students = studentRepository.findByMajorName(majorName);
        return students;
    }

}