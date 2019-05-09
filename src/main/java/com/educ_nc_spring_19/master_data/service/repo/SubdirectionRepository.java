package com.educ_nc_spring_19.master_data.service.repo;

import com.educ_nc_spring_19.master_data.model.entity.Subdirection;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SubdirectionRepository extends CrudRepository<Subdirection, UUID> {
    Iterable<Subdirection> findByDirectionIdIsNull();
}
