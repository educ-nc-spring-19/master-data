package com.educ_nc_spring_19.master_data.model.entity;

import com.educ_nc_spring_19.educ_nc_spring_19_common.common.CreatedUpdatedDateByUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "direction_id", nullable = false)
    private Direction direction;

    @Column(name = "direction_id", insertable = false, updatable = false)
    private UUID directionId;

    private String externalId;

    @Embedded
    private CreatedUpdatedDateByUser createdUpdatedDateByUser;

    @JsonIgnore
    @OneToMany(mappedBy = "subdirection")
    private Set<Student> students;
}
