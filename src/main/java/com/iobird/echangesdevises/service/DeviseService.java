package com.iobird.echangesdevises.service;

import com.iobird.echangesdevises.dto.DeviseDto;
import com.iobird.echangesdevises.dto.DtoMapper;
import com.iobird.echangesdevises.exceptions.ResourceNotFoundException;
import com.iobird.echangesdevises.repository.DeviseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviseService {

    private final DeviseRepository deviseRepository;

    @Autowired
    public DeviseService(DeviseRepository deviseRepository) {
        this.deviseRepository = deviseRepository;
    }

    public List<DeviseDto> findAll() {
        List<DeviseDto> deviseDtoList = deviseRepository.findAll().stream().map(DtoMapper.INSTANCE::toDto).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(deviseDtoList)) {
            throw new ResourceNotFoundException("Aucun devise trouvés");
        }
        return deviseDtoList;
    }

    public DeviseDto findById(Long id) {
        return deviseRepository.findById(id).map(DtoMapper.INSTANCE::toDto).orElseThrow(() -> new ResourceNotFoundException("Devise non trouvé"));
    }

}
