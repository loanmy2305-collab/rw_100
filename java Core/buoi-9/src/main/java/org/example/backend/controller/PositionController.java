package org.example.backend.controller;

import org.example.backend.service.IPositionService;
import org.example.backend.service.impl.PositionServiceImpl;
import org.example.entity.Position;

import java.util.List;

public class PositionController {
    private IPositionService positionService = new PositionServiceImpl();

    public List<Position> findAll(){
        // lấy ds từu service
        List<Position> positions = positionService.findAll();
        return positions;
    }

    public boolean insert(String name){
        boolean check = positionService.insert(name);
        return check;
    }

    public boolean deletePosition(int id){
        boolean check = positionService.deletePosition(id);
        return check;
    }

    public boolean updatePosition(int id, String updateName) {
        boolean check = positionService.updatePosition(id, updateName);
        return  check;
    }

    public List<Position> findByName(String searchName) {
        List<Position> positions = positionService.findByName(searchName);
        return positions;
    }

}
