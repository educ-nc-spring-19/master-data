package com.educ_nc_spring_19.master_data.controller;

import com.educ_nc_spring_19.master_data.mapper.MentorMapper;
import com.educ_nc_spring_19.master_data.mapper.StudentMapper;
import com.educ_nc_spring_19.master_data.mapper.SubdirectionMapper;
import com.educ_nc_spring_19.master_data.model.entity.Mentor;
import com.educ_nc_spring_19.master_data.model.entity.Student;
import com.educ_nc_spring_19.master_data.model.entity.Subdirection;
import com.educ_nc_spring_19.master_data.service.DataBindService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.collections4.MapUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/master-data/rest/api/v1/rpc")
public class RemoteProcedureController {
    private final DataBindService dataBindService;

    private final SubdirectionMapper subdirectionMapper;
    private final MentorMapper mentorMapper;
    private final StudentMapper studentMapper;

    @PatchMapping(path = "/bind-all-data", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> bindAllData() {
        Map<String, Iterable<?>> resultOfBind = dataBindService.bindAll();
        if (MapUtils.isEmpty(resultOfBind)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        Map<String, Iterable<?>> response = new HashMap<>();

        List<Subdirection> subdirections = new LinkedList<>();
        if (!IterableUtils.isEmpty(resultOfBind.get("subdirections"))) {
            resultOfBind.get("subdirections").forEach(subdirection -> subdirections.add((Subdirection) subdirection));
            response.put("subdirections", subdirectionMapper.toSubdirectionsDTO(subdirections));
        }

        List<Mentor> mentors = new LinkedList<>();
        if (!IterableUtils.isEmpty(resultOfBind.get("mentors"))) {
            resultOfBind.get("mentors").forEach(mentor -> mentors.add((Mentor) mentor));
            response.put("mentors", mentorMapper.toMentorsDTO(mentors));
        }

        List<Student> students = new LinkedList<>();
        if (!IterableUtils.isEmpty(resultOfBind.get("students"))) {
            resultOfBind.get("students").forEach(student -> students.add((Student) student));
            response.put("students", studentMapper.toStudentsDTO(students));
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
