package com.educ_nc_spring_19.master_data.service;

import com.educ_nc_spring_19.master_data.model.entity.Mentor;
import com.educ_nc_spring_19.master_data.service.repo.MentorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class MentorService {
    private final MentorRepository mentorRepository;

    public List<Mentor> findAllMentors() {
        List<Mentor> mentors = new ArrayList<>();
        mentorRepository.findAll().forEach(mentors::add);
        return mentors;
    }

    public List<Mentor> findAllByUserId(Iterable<UUID> userIds) {
        return mentorRepository.findByUserIdIn(userIds);
    }

    public List<Mentor> findAllById(Iterable<UUID> ids) {
        List<Mentor> mentors = new ArrayList<>();
        mentorRepository.findAllById(ids).forEach(mentors::add);
        return mentors;
    }

    public Optional<Mentor> findById(UUID id) {
        return mentorRepository.findById(id);
    }
}
