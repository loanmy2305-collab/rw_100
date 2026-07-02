package org.example.repository;
import org.example.entity.Position;

import java.util.List;


public interface IPositionRepository {
    List<Position> findAll();
    Position findById(Integer id);
    void update(String updateName, Integer id);
    void create(Position position);
    void delete(Integer id);
}
