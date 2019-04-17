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

    public List<Mentor> findAll() {
        List<Mentor> mentors = new LinkedList<>();
        mentorRepository.findAll().forEach(mentors::add);
        return mentors;
    }

    public List<Mentor> findAllByUserId(Iterable<UUID> userIds) {
        return mentorRepository.findAllByUserIdIn(userIds);
    }

    public List<Mentor> findAllById(Iterable<UUID> ids) {
        List<Mentor> mentors = new LinkedList<>();
        mentorRepository.findAllById(ids).forEach(mentors::add);
        return mentors;
    }

    public Optional<Mentor> findById(UUID id) {
        return mentorRepository.findById(id);
    }

    public List<Mentor> findAllByDirectionId(UUID directionId) {
        return mentorRepository.findAllByDirectionId(directionId);
    }

    public <S extends Mentor> Iterable<S> saveAll(Iterable<S> mentors) {
        return mentorRepository.saveAll(mentors);
    }
}
