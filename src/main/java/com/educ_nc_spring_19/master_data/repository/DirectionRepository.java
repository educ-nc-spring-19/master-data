package com.educ_nc_spring_19.master_data.repository;

import com.educ_nc_spring_19.master_data.entity.Direction;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DirectionRepository extends CrudRepository<Direction, UUID> {
}
