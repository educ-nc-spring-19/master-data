package com.educ_nc_spring_19.master_data.service.repo;

import com.educ_nc_spring_19.master_data.model.entity.Mentor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface MentorRepository extends CrudRepository<Mentor, UUID> {
    List<Mentor> findByUserIdIn(Iterable<UUID> userIds);
}
