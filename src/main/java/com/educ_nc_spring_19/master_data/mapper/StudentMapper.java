package com.educ_nc_spring_19.master_data.mapper;

import com.educ_nc_spring_19.educ_nc_spring_19_common.common.dto.StudentDTO;
import com.educ_nc_spring_19.master_data.model.entity.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    StudentDTO toStudentDTO(Student student);
    List<StudentDTO> toStudentsDTO(List<Student> students);
    Student toStudent(StudentDTO studentDTO);
}
