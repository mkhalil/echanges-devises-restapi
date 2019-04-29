package com.iobird.echangesdevises.controller;

import com.iobird.echangesdevises.dto.TauxDeviseDto;
import com.iobird.echangesdevises.model.TauxDevise;
import com.iobird.echangesdevises.service.TauxDeviseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/taux-devises", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class TauxDeviseController {


    private final TauxDeviseService tauxDeviseService;

    @Autowired
    public TauxDeviseController(TauxDeviseService tauxDeviseService) {
        this.tauxDeviseService = tauxDeviseService;
    }

    @PostMapping
    public Optional<TauxDevise> create(@RequestBody TauxDeviseDto tauxJournalierDeviseDto) {
        return tauxDeviseService.save(tauxJournalierDeviseDto);

    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        tauxDeviseService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Optional<TauxDevise> update(@PathVariable("id") Long id, @RequestBody TauxDeviseDto tauxJournalierDeviseDto) {
        tauxJournalierDeviseDto.setId(id);
        return tauxDeviseService.update(tauxJournalierDeviseDto);
    }

    @GetMapping
    public List<TauxDeviseDto> search(@RequestParam(required = false, name = "dateTaux")
                                      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateTaux) {
        return tauxDeviseService.search(dateTaux);
    }


}
