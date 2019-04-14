package com.educ_nc_spring_19.master_data.service;

import com.educ_nc_spring_19.master_data.model.entity.Student;
import com.educ_nc_spring_19.master_data.service.repo.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    public Optional<Student> findById(UUID id) {
        return studentRepository.findById(id);
    }

    public List<Student> findAllById(List<UUID> ids) {
        List<Student> students = new ArrayList<>();
        studentRepository.findAllById(ids).forEach(students::add);
        return students;
    }
}
