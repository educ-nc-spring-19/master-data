package com.educ_nc_spring_19.master_data.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)

@Entity
public class Mentor extends Member {
    private String description;
    private String acronym;
    private String deptName;

    @Column(unique = true, nullable = false)
    private String externalId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "interviewer", fetch = FetchType.LAZY)
    private List<Student> students;
}
