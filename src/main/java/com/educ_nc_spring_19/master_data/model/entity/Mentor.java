package com.educ_nc_spring_19.master_data.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)

@Entity
public class Mentor extends Member {
    private String description;
    private String acronym;

    @OneToMany(mappedBy = "interviewer")
    private Set<Student> students;
}
