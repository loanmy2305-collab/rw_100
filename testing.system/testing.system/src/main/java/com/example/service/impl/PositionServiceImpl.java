package com.example.service.impl;

import com.example.dto.DepartmentDTO;
import com.example.dto.PositionDTO;
import com.example.entity.Department;
import com.example.entity.Position;
import com.example.form.PositionCreateOrUpdateForm;
import com.example.repository.IPositionRepository;
import com.example.service.IPositionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PositionServiceImpl implements IPositionService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IPositionRepository positionRepository; // =new


    @Override
    public List<PositionDTO> findAll() {
        List<Position> positions = positionRepository.findAll();
        return positions.stream().map(po -> modelMapper.map(po, PositionDTO.class)).toList();
    }

    @Override
    public PositionDTO findById(Integer id) {
        Position position = positionRepository.findById(id).orElse(null);
        PositionDTO dto = null;
        if (Objects.nonNull(position)) {
            dto = modelMapper.map(position, PositionDTO.class);
        }
        return dto;
    }

    @Override
    public void deleteById(Integer id) {
        positionRepository.deleteById(id);
    }

    @Override
    public void create(PositionCreateOrUpdateForm form) {
        if (positionRepository.existsByName(form.getName())) {
            throw new RuntimeException("Department already exists");

        }
        Position position = modelMapper.map(form, Position.class);

        positionRepository.save(position);

    }


    @Override
    public void update(PositionCreateOrUpdateForm form, Integer id) {
        // tìm dep câần update theo id
        Position position = positionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        if (positionRepository.existsByNameAndIdNot(form.getName(), id)) {
            throw new RuntimeException("Department already exists");
        }

        position.setName(form.getName());

        positionRepository.save(position);
    }
    }

