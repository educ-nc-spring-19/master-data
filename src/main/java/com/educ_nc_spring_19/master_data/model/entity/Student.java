package com.educ_nc_spring_19.master_data.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

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

    // поправить SQL файлы
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interviewer_id", referencedColumnName = "id")
    private Mentor interviewer;

    @Column(name = "interviewer_id", insertable = false, updatable = false)
    private UUID interviewerId;

    private String extInterviewerId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subdirection_id", referencedColumnName = "id")
    private Subdirection subdirection;

    @Column(name = "subdirection_id", insertable = false, updatable = false)
    private UUID subdirectionId;

    private String extSubdirectionId;

    @Column(name = "external_id", unique = true, nullable = false)
    private String externalId;
}
