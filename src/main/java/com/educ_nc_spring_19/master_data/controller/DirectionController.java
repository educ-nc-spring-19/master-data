package com.educ_nc_spring_19.master_data.controller;

import com.educ_nc_spring_19.master_data.mapper.DirectionMapper;
import com.educ_nc_spring_19.master_data.model.entity.Direction;
import com.educ_nc_spring_19.master_data.service.DirectionService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/master-data/rest/api/v1/direction")
public class DirectionController {
    private final DirectionService directionService;
    private final DirectionMapper directionMapper;

    @GetMapping
    public ResponseEntity find(@RequestParam(value = "id", required = false) List<UUID> ids) {

        if (CollectionUtils.isEmpty(ids)) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(directionMapper.toDirectionsDTO(directionService.findAll()));
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(directionMapper.toDirectionsDTO(directionService.findAllById(ids)));

    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable(name = "id") UUID id) {
        Optional<Direction> direction = directionService.findById(id);
        return direction.isPresent()
                ? ResponseEntity.status(HttpStatus.OK).body(directionMapper.toDirectionDTO(direction.get()))
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
