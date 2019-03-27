package com.educ_nc_spring_19.master_data.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Mentor extends Member {
    private String description;

    @OneToMany(mappedBy = "interviewer")
    private Set<Student> students;

    protected Mentor() {
        super();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
