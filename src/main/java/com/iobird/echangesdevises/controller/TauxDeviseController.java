package com.iobird.echangesdevises.controller;

import com.iobird.echangesdevises.component.TauxDeviseResourceMapper;
import com.iobird.echangesdevises.dto.TauxDeviseDto;
import com.iobird.echangesdevises.service.TauxDeviseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/taux-devises", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class TauxDeviseController {


    private final TauxDeviseService tauxDeviseService;

    private final TauxDeviseResourceMapper tauxDeviseResourceMapper;

    @Autowired
    public TauxDeviseController(TauxDeviseService tauxDeviseService, TauxDeviseResourceMapper tauxDeviseResourceMapper) {
        this.tauxDeviseService = tauxDeviseService;
        this.tauxDeviseResourceMapper = tauxDeviseResourceMapper;
    }

    @PostMapping
    public ResponseEntity<Resource<TauxDeviseDto>> newTaux(@RequestBody TauxDeviseDto tauxJournalierDeviseDto) throws URISyntaxException {
        Resource<TauxDeviseDto> resource = tauxDeviseResourceMapper.toResource(tauxDeviseService.newTauxDevise(tauxJournalierDeviseDto));
        return ResponseEntity.created(new URI(resource.getId().expand().getHref())).body(resource);

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        tauxDeviseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resource<TauxDeviseDto>> update(@PathVariable("id") Long id, @RequestBody TauxDeviseDto tauxJournalierDeviseDto) throws URISyntaxException {
        Resource<TauxDeviseDto> resource = tauxDeviseResourceMapper.toResource(tauxDeviseService.update(id, tauxJournalierDeviseDto));
        return ResponseEntity.created(new URI(resource.getId().expand().getHref())).body(resource);
    }


    @GetMapping("/{id}")
    public Resource<TauxDeviseDto> get(@PathVariable("id") Long id) {
        return tauxDeviseResourceMapper.toResource(tauxDeviseService.findById(id));
    }

    @GetMapping
    public List<Resource<TauxDeviseDto>> list() {
        return this.searchByDate(null);
    }

    @GetMapping("/current")
    public List<Resource<TauxDeviseDto>> current() {
        return this.searchByDate(LocalDate.now());
    }

    @GetMapping("/search")
    public List<Resource<TauxDeviseDto>> search(@RequestParam(required = false, name = "dateTaux")
                                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateTaux) {
        return this.searchByDate(dateTaux);
    }


    private List<Resource<TauxDeviseDto>> searchByDate(LocalDate dateTaux) {
        return tauxDeviseService.search(dateTaux).stream().map(tauxDeviseResourceMapper::toResource).collect(Collectors.toList());
    }

}
