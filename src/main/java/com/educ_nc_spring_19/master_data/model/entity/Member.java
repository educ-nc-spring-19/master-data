package com.educ_nc_spring_19.master_data.model.entity;

import com.educ_nc_spring_19.educ_nc_spring_19_common.common.CreatedUpdatedDateByUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Member {
    @Id
    @GeneratedValue
    private UUID id;

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private String externalId;

    @Column(nullable = false)
    private UUID userId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "direction_id", nullable = false)
    private Direction direction;

    @Column(name = "direction_id", insertable = false, updatable = false)
    private UUID directionId;

    @JsonUnwrapped
    @Embedded
    private CreatedUpdatedDateByUser createdUpdatedDateByUser;
}
