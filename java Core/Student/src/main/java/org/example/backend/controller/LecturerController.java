package org.example.backend.controller;

import org.example.backend.service.ILecturerService;
import org.example.backend.service.impl.LecturerServiceimpl;
import org.example.entity.Lecturer;

public class LecturerController {
    private ILecturerService lecturerService = new LecturerServiceimpl();

    public Lecturer findById(int id) {
        return lecturerService.findById(id);
    }
}
