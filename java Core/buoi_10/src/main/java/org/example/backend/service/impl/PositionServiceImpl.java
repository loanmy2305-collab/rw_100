package org.example.backend.service.impl;

import org.example.backend.repository.IPositionRepository;
import org.example.backend.repository.impl.PositionRepositoryImpl;
import org.example.backend.service.IPositionService;
import org.example.entity.Position;

import java.util.List;

public class PositionServiceImpl implements IPositionService {
    private IPositionRepository positionRepository = new PositionRepositoryImpl();

    @Override
    public List<Position> findAll() {
        List<Position> positions = positionRepository.findAll();
        return positions;
    }

    @Override
    public boolean insert(String name) {
        boolean check = positionRepository.insert(name);
        return check;
    }

    @Override
    public boolean deletePosition(int id) {
        boolean check = positionRepository.deletePosition(id);
        return  check;
    }

    @Override
    public List<Position> findByName(String searchName) {
        List<Position> positions = positionRepository.findByName(searchName);
        return positions;
    }

    @Override
    public boolean updatePosition(int id, String updateName) {
        boolean check = positionRepository.updatePosition(id, updateName);
        return  check;
    }

    @Override
    public boolean checkExistNameAndIdNot(String name, Integer id) {
        return positionRepository.checkExistNameAndIdNot(name, id);
    }

    @Override
    public boolean checkExistID(Integer id) {
        return positionRepository.checkExistID(id);
    }



}

