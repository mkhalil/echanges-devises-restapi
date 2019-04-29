package com.iobird.echangesdevises.controller;

import com.iobird.echangesdevises.dto.DeviseDto;
import com.iobird.echangesdevises.service.DeviseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/devises", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class DevisesController {

    private final DeviseService deviseService;


    @Autowired
    public DevisesController(DeviseService deviseService) {
        this.deviseService = deviseService;
    }


    @GetMapping
    public List<DeviseDto> list() {
        return deviseService.findAll();
    }

    @GetMapping("/{id}")
    public DeviseDto findById(@PathVariable("id") Long id) {
        return deviseService.findById(id);
    }


}
