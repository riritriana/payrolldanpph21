package com.project.payrolldanpph21.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.payrolldanpph21.models.Position;
import com.project.payrolldanpph21.repositories.PositionRepository;

@Service
public class PositionService {
    @Autowired
    private PositionRepository positionRepository;

    public void save(Position position){
        positionRepository.save(position);
    }

    public List<Position> getAllPositions(){
        return positionRepository.findAll();
    }

    public void delete(Long id){
        positionRepository.deleteById(id);
    }

    public Position findById(Long id){
        return positionRepository.findById(id).orElse(null);
    }
}
