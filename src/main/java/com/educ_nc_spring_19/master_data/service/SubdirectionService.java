package com.educ_nc_spring_19.master_data.service;

import com.educ_nc_spring_19.master_data.model.entity.Subdirection;
import com.educ_nc_spring_19.master_data.service.repo.SubdirectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class SubdirectionService {
    private final SubdirectionRepository subdirectionRepository;

    public List<Subdirection> findAll() {
        List<Subdirection> subdirections = new LinkedList<>();
        subdirectionRepository.findAll().forEach(subdirections::add);
        return subdirections;
    }

    public List<Subdirection> findAllById(Iterable<UUID> ids) {
        List<Subdirection> subdirections = new LinkedList<>();
        subdirectionRepository.findAllById(ids).forEach(subdirections::add);
        return subdirections;
    }

    public Optional<Subdirection> findById(UUID id) {
        return subdirectionRepository.findById(id);
    }

    public List<Subdirection> findByDirectionIdIsNull() {
        List<Subdirection> subdirections = new LinkedList<>();
        subdirectionRepository.findByDirectionIdIsNull().forEach(subdirections::add);
        return subdirections;
    }

    public <S extends Subdirection> Iterable<S> saveAll(Iterable<S> subdirections) {
        return subdirectionRepository.saveAll(subdirections);
    }
}
