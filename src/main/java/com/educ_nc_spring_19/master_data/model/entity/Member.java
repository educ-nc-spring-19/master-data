package com.educ_nc_spring_19.master_data.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;
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

    @ManyToOne
    @JoinColumn(name = "direction_id", nullable = false)
    private Direction direction;

    @Column(columnDefinition = "timestamp with time zone")
    private OffsetDateTime createdDate;
    private UUID createdByUserId;

    @Column(columnDefinition = "timestamp with time zone")
    private OffsetDateTime updatedDate;
    private UUID updatedByUserId;
}
