package com.educ_nc_spring_19.master_data.service;

import com.educ_nc_spring_19.master_data.model.entity.Direction;
import com.educ_nc_spring_19.master_data.service.repo.DirectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class DirectionService {
    private final DirectionRepository directionRepository;

    public List<Direction> findAll() {
        List<Direction> directions = new LinkedList<>();
        directionRepository.findAll().forEach(directions::add);
        return directions;
    }

    public List<Direction> findAllById(Iterable<UUID> ids) {
        List<Direction> directions = new LinkedList<>();
        directionRepository.findAllById(ids).forEach(directions::add);
        return directions;
    }

    public Optional<Direction> findById(UUID id) {
        return directionRepository.findById(id);
    }
}
