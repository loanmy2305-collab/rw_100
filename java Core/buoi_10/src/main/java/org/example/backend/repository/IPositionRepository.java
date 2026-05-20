package org.example.backend.repository;

import org.example.entity.Position;

import java.util.List;

public interface IPositionRepository {
    List<Position> findAll();
    boolean insert(String name);
    boolean deletePosition(int id);
    boolean updatePosition(int id, String updateName);
    List<Position> findByName(String searchName);
    boolean checkExistID(Integer id);
    boolean checkExistNameAndIdNot(String name, Integer id);
}
