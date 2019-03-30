package com.educ_nc_spring_19.master_data.model.entity;

import com.educ_nc_spring_19.educ_nc_spring_19_common.common.CreatedUpdatedDateByUser;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Data

@Entity
public class Subdirection {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "direction_id", nullable = false)
    private Direction direction;

    private String externalId;

    @Embedded
    private CreatedUpdatedDateByUser createdUpdatedDateByUser;

    @OneToMany(mappedBy = "subdirection")
    private Set<Student> students;
}
