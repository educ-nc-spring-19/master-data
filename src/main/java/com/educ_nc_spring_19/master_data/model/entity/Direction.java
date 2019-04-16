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
public class Direction implements Auditable, Serializable {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String description;

    @Column(unique = true, nullable = false)
    private String externalId;

    @Embedded
    private Audit audit;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "direction",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Member> members;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "direction",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Subdirection> subdirections;
}
