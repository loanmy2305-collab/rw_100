package org.example.repository;
import org.example.entity.Position;

import java.util.List;

public interface IPositionRepository {
    List<Position> findAll();
    Position findById(Integer id);
    void create(String name);
    void update(String updateName, Integer id);
}
