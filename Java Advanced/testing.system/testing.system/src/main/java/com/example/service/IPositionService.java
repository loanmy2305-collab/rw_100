package com.example.service;


import com.example.entity.Position;

import java.util.List;

public interface IPositionService {
    List<Position> findAll();

    Position findById(Integer id);

    void deleteById(Integer id);

    void create(Position position);

    void update(Position position, Integer id);
}
