package com.example.service;


import com.example.dto.PositionDTO;
import com.example.entity.Position;
import com.example.form.PositionCreateOrUpdateForm;

import java.util.List;

public interface IPositionService {
    List<PositionDTO> findAll();

    PositionDTO findById(Integer id);

    void deleteById(Integer id);

    void create(PositionCreateOrUpdateForm position);

    void update(PositionCreateOrUpdateForm position, Integer id);
}
