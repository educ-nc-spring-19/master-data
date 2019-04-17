package com.educ_nc_spring_19.master_data.service;

import com.educ_nc_spring_19.master_data.model.entity.Direction;
import com.educ_nc_spring_19.master_data.model.entity.Mentor;
import com.educ_nc_spring_19.master_data.model.entity.Student;
import com.educ_nc_spring_19.master_data.model.entity.Subdirection;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@RequiredArgsConstructor
@Service
public class DataBindService {

    private final DirectionService directionService;
    private final SubdirectionService subdirectionService;
    private final MentorService mentorService;
    private final StudentService studentService;

    // TO DO
    public Map<String, Iterable<?>> bindAll() {
        List<Direction> directions = directionService.findAll();
        List<Subdirection> subdirections = subdirectionService.findAll();
        List<Mentor> mentors = mentorService.findAll();
        List<Student> students = studentService.findAll();

        // bind all with directions
        if (CollectionUtils.isNotEmpty(directions)) {
            Map<String, Direction> extIdDirectionMap = new HashMap<>();
            directions.forEach(direction -> extIdDirectionMap.put(direction.getExternalId(), direction));

            subdirections.forEach(subdirection ->
                    subdirection.setDirection(extIdDirectionMap.getOrDefault(subdirection.getExtDirectionId(), null)));
            mentors.forEach(mentor ->
                    mentor.setDirection(extIdDirectionMap.getOrDefault(mentor.getExtDirectionId(), null)));
            students.forEach(student ->
                    student.setDirection(extIdDirectionMap.getOrDefault(student.getExtDirectionId(), null)));
        }

        // bind subdirections to students
        if (CollectionUtils.isNotEmpty(subdirections)) {
            Map<String, Subdirection> extIdSubdirectionMap = new HashMap<>();
            subdirections.forEach(subdirection -> extIdSubdirectionMap.put(subdirection.getExternalId(), subdirection));

            students.stream().filter(student -> !StringUtils.isBlank(student.getExtSubdirectionId()))
                    .forEach(student -> student.setSubdirection(extIdSubdirectionMap.getOrDefault(student.getExtSubdirectionId(), null)));
        }

        // bind interviewers to students
        if (CollectionUtils.isNotEmpty(mentors)) {
            Map<String, Mentor> extIdMentorMap = new HashMap<>();
            mentors.forEach(mentor -> extIdMentorMap.put(mentor.getExternalId(), mentor));

            students.stream().filter(student -> !StringUtils.isBlank(student.getExtInterviewerId()))
                    .forEach(student -> student.setInterviewer(extIdMentorMap.getOrDefault(student.getExtInterviewerId(), null)));
        }

        Map<String, Iterable<?>> result = new HashMap<>();

        if (CollectionUtils.isNotEmpty(subdirections)) {
            result.put("subdirections", subdirectionService.saveAll(subdirections));
        }

        if (CollectionUtils.isNotEmpty(mentors)) {
            result.put("mentors", mentorService.saveAll(mentors));
        }

        if (CollectionUtils.isNotEmpty(students)) {
            result.put("students", studentService.saveAll(students));
        }

        return result;
    }
}
