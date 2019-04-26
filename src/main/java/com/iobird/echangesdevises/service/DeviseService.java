package com.iobird.echangesdevises.service;

import com.iobird.echangesdevises.dto.DeviseDto;
import com.iobird.echangesdevises.dto.DtoMapper;
import com.iobird.echangesdevises.repository.DeviseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeviseService {

    private final DeviseRepository deviseRepository;

    @Autowired
    public DeviseService(DeviseRepository deviseRepository) {
        this.deviseRepository = deviseRepository;
    }

    public List<DeviseDto> findAll() {
        return deviseRepository.findAll().stream().map(DtoMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    public Optional<DeviseDto> findById(Long id) {
        return deviseRepository.findById(id).map(DtoMapper.INSTANCE::toDto);
    }

}
