package com.educ_nc_spring_19.master_data.controller;

import com.educ_nc_spring_19.educ_nc_spring_19_common.common.dto.StudentDTO;
import com.educ_nc_spring_19.master_data.mapper.StudentMapper;
import com.educ_nc_spring_19.master_data.model.entity.Student;
import com.educ_nc_spring_19.master_data.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/master-data/rest/api/v1/student")
public class StudentController {
    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @GetMapping
    public ResponseEntity findAllById(@RequestParam(value = "id", required = false) List<UUID> ids) {

        if (CollectionUtils.isEmpty(ids)) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(studentMapper.toStudentsDTO(studentService.findAll()));
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(studentMapper.toStudentsDTO(studentService.findAllById(ids)));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable(name = "id") UUID id) {
        Optional<Student> student = studentService.findById(id);
        return student.isPresent()
                ? ResponseEntity.status(HttpStatus.OK).body(studentMapper.toStudentDTO(student.get()))
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
