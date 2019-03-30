package com.educ_nc_spring_19.master_data.model.entity;

import com.educ_nc_spring_19.educ_nc_spring_19_common.common.CreatedUpdatedDateByUser;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Data

@Entity
public class Direction {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String description;
    private String externalId;

    @Embedded
    private CreatedUpdatedDateByUser createdUpdatedDateByUser;

    @OneToMany(mappedBy = "direction")
    private Set<Member> members;

    @OneToMany(mappedBy = "direction")
    private Set<Subdirection> subdirections;
}
