package org.example.backend.service.impl;


import org.example.backend.service.ILecturerService;
import org.example.entity.Lecturer;

public class LecturerServiceimpl implements ILecturerService {
    private ILecturerService lecturerService =new LecturerServiceimpl();

    @Override
    public Lecturer findById(int id) {
        return lecturerService.findById(id);
    }
}
