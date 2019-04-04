package com.educ_nc_spring_19.master_data.model.entity;

import com.educ_nc_spring_19.educ_nc_spring_19_common.common.CreatedUpdatedDateByUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
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

    @JsonIgnore
    @OneToMany(mappedBy = "direction")
    private List<Member> members;

    @JsonIgnore
    @OneToMany(mappedBy = "direction")
    private List<Subdirection> subdirections;
}
