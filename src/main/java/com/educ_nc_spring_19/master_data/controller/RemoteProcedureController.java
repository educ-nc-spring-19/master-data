package com.educ_nc_spring_19.master_data.controller;

import com.educ_nc_spring_19.master_data.mapper.MentorMapper;
import com.educ_nc_spring_19.master_data.mapper.StudentMapper;
import com.educ_nc_spring_19.master_data.mapper.SubdirectionMapper;
import com.educ_nc_spring_19.master_data.model.entity.Mentor;
import com.educ_nc_spring_19.master_data.model.entity.Student;
import com.educ_nc_spring_19.master_data.model.entity.Subdirection;
import com.educ_nc_spring_19.master_data.service.DataBindService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
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

    @SuppressWarnings("unchecked")
    @PatchMapping(path = "/bind-all-data", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> bindAllData() {
        Map<String, List<?>> resultOfBind = dataBindService.bindAll();
        if (MapUtils.isEmpty(resultOfBind)) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        Map<String, List<?>> response = new HashMap<>();

        // Unchecked casts, but we trust to map keys returned from DataBindService
        if (CollectionUtils.isNotEmpty(resultOfBind.get("subdirections"))) {
            response.put("subdirections", subdirectionMapper.toSubdirectionsDTO((List<Subdirection>) resultOfBind.get("subdirections")));
        }

        if (CollectionUtils.isNotEmpty(resultOfBind.get("mentors"))) {
            response.put("mentors", mentorMapper.toMentorsDTO((List<Mentor>) resultOfBind.get("mentors")));
        }

        if (CollectionUtils.isNotEmpty(resultOfBind.get("students"))) {
            response.put("students", studentMapper.toStudentsDTO((List<Student>) resultOfBind.get("students")));
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
