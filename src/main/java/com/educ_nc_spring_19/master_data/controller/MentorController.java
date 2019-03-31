package com.educ_nc_spring_19.master_data.controller;

import com.educ_nc_spring_19.master_data.model.bean.MentorIdUserId;
import com.educ_nc_spring_19.master_data.model.entity.Mentor;
import com.educ_nc_spring_19.master_data.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/master-data/rest/api/v1/mentor")
public class MentorController {

    @Autowired
    private MentorService mentorService;

    @GetMapping("")
    public MentorIdUserId getMentorIdByUserId(@RequestParam(value = "userId") UUID userId) {
        return new MentorIdUserId(mentorService.findMentorIdByUserId(userId),
                                  userId);
    }

    @GetMapping("/all")
    public List<Mentor> getAllMentors() {
        return mentorService.findAllMentors();
    }
}
