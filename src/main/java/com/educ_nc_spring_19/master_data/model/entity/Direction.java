package com.educ_nc_spring_19.master_data.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;
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

    @Column(columnDefinition= "timestamp with time zone")
    private OffsetDateTime createdDate;
    private UUID createdByUserId;

    @Column(columnDefinition= "timestamp with time zone")
    private OffsetDateTime updatedDate;
    private UUID updatedByUserId;

    @OneToMany(mappedBy = "direction")
    private Set<Member> members;

    @OneToMany(mappedBy = "direction")
    private Set<Subdirection> subdirections;
}
