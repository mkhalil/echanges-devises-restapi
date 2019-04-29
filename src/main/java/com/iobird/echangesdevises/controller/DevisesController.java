package com.iobird.echangesdevises.controller;

import com.iobird.echangesdevises.component.DeviseResourceMapper;
import com.iobird.echangesdevises.dto.DeviseDto;
import com.iobird.echangesdevises.service.DeviseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/devises", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class DevisesController {

    private final DeviseService deviseService;

    private final
    DeviseResourceMapper deviseResourceMapper;


    @Autowired
    public DevisesController(DeviseService deviseService, DeviseResourceMapper deviseResourceMapper) {
        this.deviseService = deviseService;
        this.deviseResourceMapper = deviseResourceMapper;
    }


    @GetMapping
    public List<Resource<DeviseDto>> list() {
        return deviseService.findAll().stream().map(deviseResourceMapper::toResource).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Resource<DeviseDto> findById(@PathVariable("id") Long id) {
        return deviseResourceMapper.toResource(deviseService.findById(id));
    }


}
