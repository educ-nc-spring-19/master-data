package com.educ_nc_spring_19.master_data.model.entity;

import com.educ_nc_spring_19.educ_nc_spring_19_common.common.Audit;
import com.educ_nc_spring_19.educ_nc_spring_19_common.common.Auditable;
import com.educ_nc_spring_19.educ_nc_spring_19_common.common.listener.AuditListener;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data

@Entity
@EntityListeners(AuditListener.class)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Member implements Auditable, Serializable {
    @Id
    @GeneratedValue
    private UUID id;

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;

    @Column(unique = true, nullable = false)
    private String externalId;

    @Column(nullable = false)
    private UUID userId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "direction_id", referencedColumnName = "id")
    private Direction direction;

    @Column(name = "direction_id", insertable = false, updatable = false)
    private UUID directionId;

    private String extDirectionId;

    @JsonUnwrapped
    @Embedded
    private Audit audit;
}
