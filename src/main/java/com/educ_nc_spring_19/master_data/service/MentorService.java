package com.educ_nc_spring_19.master_data.service;

import com.educ_nc_spring_19.master_data.model.entity.Mentor;
import com.educ_nc_spring_19.master_data.service.repo.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MentorService {
    @Autowired
    private MentorRepository mentorRepository;

    public UUID findMentorIdByUserId(UUID userId) {
        return mentorRepository.findByUserId(userId)
                .map(Mentor::getId)
                .orElse(null);
    }

    public List<Mentor> findAllMentors() {
        List<Mentor> mentors = new ArrayList<>();
        mentorRepository.findAll().forEach(mentors::add);
        return mentors;
    }
}
