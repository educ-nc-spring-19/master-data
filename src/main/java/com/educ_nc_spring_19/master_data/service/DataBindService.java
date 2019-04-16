package com.educ_nc_spring_19.master_data.service;

import com.educ_nc_spring_19.master_data.model.entity.Direction;
import com.educ_nc_spring_19.master_data.model.entity.Mentor;
import com.educ_nc_spring_19.master_data.model.entity.Student;
import com.educ_nc_spring_19.master_data.model.entity.Subdirection;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class DataBindService {

    private final DirectionService directionService;
    private final SubdirectionService subdirectionService;
    private final MentorService mentorService;
    private final StudentService studentService;

    // TO DO
    public void bind() {
        List<Direction> directions = directionService.findAll();
        List<Subdirection> subdirections = subdirectionService.findAll();
        List<Mentor> mentors = mentorService.findAll();
        List<Student> students = studentService.findAll();

        if (CollectionUtils.isNotEmpty(directions)) {
            Map<String, Direction> extIdDirectionMap = new HashMap<>();
            for (Direction direction : directions) {
                extIdDirectionMap.put(direction.getExternalId(), direction);
            }

            subdirections.forEach(subdirection ->
                    subdirection.setDirection(extIdDirectionMap.getOrDefault(subdirection.getExtDirectionId(), null)));
            mentors.forEach(mentor ->
                    mentor.setDirection(extIdDirectionMap.getOrDefault(mentor.getExtDirectionId(), null)));
            students.forEach(student ->
                    student.setDirection(extIdDirectionMap.getOrDefault(student.getExtDirectionId(), null)));
        }
    }
}
