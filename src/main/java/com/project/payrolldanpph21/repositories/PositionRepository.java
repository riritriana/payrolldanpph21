package com.project.payrolldanpph21.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.payrolldanpph21.models.Position;

public interface PositionRepository extends JpaRepository<Position,Long>{
    
}
