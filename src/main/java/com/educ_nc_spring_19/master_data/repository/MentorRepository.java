package com.educ_nc_spring_19.master_data.repository;

import com.educ_nc_spring_19.master_data.entity.Mentor;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MentorRepository extends CrudRepository<Mentor, UUID> {
}
