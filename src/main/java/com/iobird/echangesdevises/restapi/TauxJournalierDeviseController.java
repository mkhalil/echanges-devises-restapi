package com.iobird.echangesdevises.restapi;

import com.iobird.echangesdevises.dto.TauxJournalierDeviseDto;
import com.iobird.echangesdevises.model.TauxJournalierDevise;
import com.iobird.echangesdevises.service.TauxJournalierDeviseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/taux-echanges-devises", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class TauxJournalierDeviseController {


    @Autowired
    TauxJournalierDeviseService tauxJournalierDeviseService;

    @PostMapping
    public Optional<TauxJournalierDevise> create(@RequestBody TauxJournalierDeviseDto tauxJournalierDeviseDto) {
        return tauxJournalierDeviseService.save(tauxJournalierDeviseDto);

    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        tauxJournalierDeviseService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Optional<TauxJournalierDevise> update(@PathVariable("id") Long id, @RequestBody TauxJournalierDeviseDto tauxJournalierDeviseDto) {
        tauxJournalierDeviseDto.setId(id);
        return tauxJournalierDeviseService.update(tauxJournalierDeviseDto);
    }

    @GetMapping
    public Iterable<TauxJournalierDevise> list() {
        return tauxJournalierDeviseService.iterableList();
    }



}
