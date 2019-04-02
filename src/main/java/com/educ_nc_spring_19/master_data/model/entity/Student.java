package com.educ_nc_spring_19.master_data.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@EqualsAndHashCode(callSuper = true)

@Entity
public class Student extends Member {
    private Integer yearOfStudy;
    private Integer semester;

    @Column(columnDefinition = "text")
    private String techComment;

    @Column(columnDefinition = "text")
    private String hrComment;

    @ManyToOne
    @JoinColumn(name = "interviewer_id", nullable = false)
    private Mentor interviewer;

    @ManyToOne
    @JoinColumn(name = "subdirection_id")
    private Subdirection subdirection;
}
