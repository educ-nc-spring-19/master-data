package com.educ_nc_spring_19.master_data.controller;

import com.educ_nc_spring_19.master_data.model.entity.Mentor;
import com.educ_nc_spring_19.master_data.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/master-data/rest/api/v1/mentor")
public class MentorController {

    private final MentorService mentorService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Mentor>> findMentorsByUserIds(
            @RequestParam(value = "userId", required = false) List<UUID> userIds) {
        if (userIds == null || userIds.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(mentorService.findAllMentors());
        }
        return ResponseEntity.status(HttpStatus.OK).body(mentorService.findAllByUserId(userIds));
    }

    @RequestMapping("/{id}")
    public ResponseEntity<Mentor> findMentorById(@PathVariable(name = "id") UUID id) {
        Optional<Mentor> mentor = mentorService.findById(id);
        return mentor.isPresent()
                ? ResponseEntity.status(HttpStatus.OK).body(mentor.get())
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
