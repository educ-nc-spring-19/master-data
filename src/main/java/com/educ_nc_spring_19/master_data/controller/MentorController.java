package com.educ_nc_spring_19.master_data.controller;

import com.educ_nc_spring_19.educ_nc_spring_19_common.common.dto.MentorDTO;
import com.educ_nc_spring_19.master_data.mapper.MentorMapper;
import com.educ_nc_spring_19.master_data.model.entity.Mentor;
import com.educ_nc_spring_19.master_data.service.MentorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/master-data/rest/api/v1/mentor")
public class MentorController {

    private final MentorService mentorService;
    private final MentorMapper mentorMapper;

    @GetMapping
    public ResponseEntity find(
            @RequestParam(value = "id", required = false) List<UUID> ids,
            @RequestParam(value = "userId", required = false) List<UUID> userIds,
            @RequestParam(value = "directionId", required = false) UUID directionId) {

        Set<Mentor> mentorsToResponse = new HashSet<>();

        if (CollectionUtils.isNotEmpty(ids)) {
            mentorsToResponse.addAll(mentorService.findAllById(ids));
        }
        if (CollectionUtils.isNotEmpty(userIds)) {
            mentorsToResponse.addAll(mentorService.findAllByUserId(userIds));
        }
        if (directionId != null) {
            mentorsToResponse.addAll(mentorService.findAllByDirectionId(directionId));
        }
        if (CollectionUtils.isEmpty(ids) && CollectionUtils.isEmpty(userIds) && directionId == null) {
            mentorsToResponse.addAll(mentorService.findAll());
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(mentorMapper.toMentorsDTO(new ArrayList<>(mentorsToResponse)));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable(name = "id") UUID id) {
        Optional<Mentor> mentor = mentorService.findById(id);
        return mentor.isPresent()
                ? ResponseEntity.status(HttpStatus.OK).body(mentorMapper.toMentorDTO(mentor.get()))
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
