package com.iobird.echangesdevises.controller;

import com.iobird.echangesdevises.dto.DeviseDto;
import com.iobird.echangesdevises.dto.TauxDeviseDto;
import com.iobird.echangesdevises.service.DeviseService;
import com.iobird.echangesdevises.service.TauxDeviseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/devises", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class DevisesController {

    private final
    DeviseService deviseService;


    private final
    TauxDeviseService tauxDeviseService;

    @Autowired
    public DevisesController(DeviseService deviseService, TauxDeviseService tauxDeviseService) {
        this.deviseService = deviseService;
        this.tauxDeviseService = tauxDeviseService;
    }


    @GetMapping
    public List<DeviseDto> list() {
        return deviseService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<DeviseDto> findById(@PathVariable("id") Long id) {
        return deviseService.findById(id);
    }

    @GetMapping("/taux")
    public List<TauxDeviseDto> taux(@RequestParam(required = false, name = "dateTaux")
                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateTaux) {
        return tauxDeviseService.search(dateTaux);
    }


}
