package org.example.backend.service;

import org.example.entity.Position;

import java.util.List;

public interface IPositionService {
    List<Position> findAll();

    List<Position> findByName(String searchName);

    boolean insert(String name);

    boolean deletePosition(int id);

    boolean updatePosition(int id, String updateName);

    boolean checkExistID(Integer id);

    boolean checkExistNameAndIdNot(String name, Integer id);

}