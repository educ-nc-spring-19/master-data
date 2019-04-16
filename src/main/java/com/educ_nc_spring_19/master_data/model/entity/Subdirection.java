package com.educ_nc_spring_19.master_data.model.entity;

import com.educ_nc_spring_19.educ_nc_spring_19_common.common.Audit;
import com.educ_nc_spring_19.educ_nc_spring_19_common.common.Auditable;
import com.educ_nc_spring_19.educ_nc_spring_19_common.common.listener.AuditListener;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data

@Entity
@EntityListeners(AuditListener.class)
public class Subdirection implements Auditable, Serializable {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String description;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "direction_id", referencedColumnName = "id")
    private Direction direction;

    @Column(name = "direction_id", insertable = false, updatable = false)
    private UUID directionId;

    private String extDirectionId;

    @Column(unique = true, nullable = false)
    private String externalId;

    @Embedded
    private Audit audit;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subdirection", fetch = FetchType.LAZY)
    private List<Student> students;
}
