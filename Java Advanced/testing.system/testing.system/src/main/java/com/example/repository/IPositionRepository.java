package com.example.repository;

import com.example.entity.Department;
import com.example.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository  extends JpaRepository<Position, Integer> {
}
