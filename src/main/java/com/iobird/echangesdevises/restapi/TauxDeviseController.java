package com.iobird.echangesdevises.restapi;

import com.iobird.echangesdevises.dto.TauxJournalierDeviseDto;
import com.iobird.echangesdevises.model.TauxDevise;
import com.iobird.echangesdevises.service.TauxDeviseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping(path = "/taux-devises", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class TauxDeviseController {


    @Autowired
    TauxDeviseService tauxDeviseService;

    @PostMapping
    public Optional<TauxDevise> create(@RequestBody TauxJournalierDeviseDto tauxJournalierDeviseDto) {
        return tauxDeviseService.save(tauxJournalierDeviseDto);

    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        tauxDeviseService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Optional<TauxDevise> update(@PathVariable("id") Long id, @RequestBody TauxJournalierDeviseDto tauxJournalierDeviseDto) {
        tauxJournalierDeviseDto.setId(id);
        return tauxDeviseService.update(tauxJournalierDeviseDto);
    }

    @GetMapping
    public Iterable<TauxDevise> list() {
        return tauxDeviseService.iterableList();
    }

    @GetMapping("/today")
    public Iterable<TauxDevise> search() {
        return tauxDeviseService.currentTaux(LocalDate.now());
    }



}
