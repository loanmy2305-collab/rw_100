package com.example.repository;

import com.example.entity.Department;
import com.example.entity.Position;
import com.example.enums.PositionName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository  extends JpaRepository<Position, Integer> {
    Position findByName(PositionName name);

    boolean existsByName(PositionName name);

    boolean existsByNameAndIdNot(PositionName name, Integer id);
}
