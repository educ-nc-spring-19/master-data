package com.educ_nc_spring_19.master_data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
public class Student extends Member {
    private Integer yearOfStudy;
    private Integer semester;

    @Column(columnDefinition = "text")
    private String techComment;

    @Column(columnDefinition = "text")
    private String hrComment;

    @ManyToOne
    @JoinColumn(name = "interviewer_id")
    private Mentor interviewer;

    @ManyToOne
    @JoinColumn(name = "subdirection_id")
    private Subdirection subdirection;

    protected Student() {
        super();
    }

    public Integer getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(Integer yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public String getTechComment() {
        return techComment;
    }

    public void setTechComment(String techComment) {
        this.techComment = techComment;
    }

    public String getHrComment() {
        return hrComment;
    }

    public void setHrComment(String hrComment) {
        this.hrComment = hrComment;
    }

    public Mentor getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(Mentor interviewer) {
        this.interviewer = interviewer;
    }

    public Subdirection getSubdirection() {
        return subdirection;
    }

    public void setSubdirection(Subdirection subdirection) {
        this.subdirection = subdirection;
    }
}
