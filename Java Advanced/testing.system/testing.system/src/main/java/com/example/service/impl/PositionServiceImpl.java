package com.example.service.impl;

import com.example.entity.Position;
import com.example.repository.IPositionRepository;
import com.example.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PositionServiceImpl implements IPositionService {

    @Autowired
    private IPositionRepository positionRepository; // =new


    @Override
    public List<Position> findAll() {
        List<Position> positions = positionRepository.findAll();
        return positions;
    }

    @Override
    public Position findById(Integer id) {
        Position position = positionRepository.findById(id).orElse(null);
        // orElse(null) :
        return position;
    }

    @Override
    public void deleteById(Integer id) {
        positionRepository.deleteById(id);
    }

    @Override
    public void create(Position position) {
        positionRepository.save(position);
    }

    @Override
    public void update(Position position, Integer id) {
        // tìm dep câần update theo id
        Position positionUpdate = positionRepository.findById(id).orElse(null);
        if (Objects.isNull(positionUpdate)){
            throw new RuntimeException("ID not found!");
        }else {
            //lưu lại thông tin update
            positionUpdate.setName(position.getName());
            positionRepository.save(positionUpdate);
        }
    }
}
