package org.example.backend.repository;

import org.example.entity.Lecturer;

public interface ILecturerRepository {
    Lecturer findById(int id);
}
