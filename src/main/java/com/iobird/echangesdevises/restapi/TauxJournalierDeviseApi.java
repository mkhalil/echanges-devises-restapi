package com.iobird.echangesdevises.restapi;

import com.iobird.echangesdevises.dto.TauxJournalierDeviseDto;
import com.iobird.echangesdevises.exceptions.BadRequestException;
import com.iobird.echangesdevises.model.Devise;
import com.iobird.echangesdevises.model.TauxJournalierDevise;
import com.iobird.echangesdevises.repository.DeviseRepository;
import com.iobird.echangesdevises.repository.TauxJournalierDeviseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/taux-echanges-devises", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class TauxJournalierDeviseApi {

    @Autowired
    TauxJournalierDeviseRepository tauxJournalierDeviseRepository;

    @Autowired
    DeviseRepository deviseRepository;


    @PostMapping
    public Optional<TauxJournalierDevise> create(@RequestBody TauxJournalierDeviseDto tauxJournalierDeviseDto) {
        Optional<Devise> optionalDevise = deviseRepository.findById(tauxJournalierDeviseDto.getDeviseId());

        optionalDevise.orElseThrow(() -> new BadRequestException("Devise non trouvé dans la base de données"));
        Optional<TauxJournalierDevise> tauxJournalierDeviseOptional = optionalDevise.map(devise ->
                new TauxJournalierDevise(null,
                        tauxJournalierDeviseDto.getMontantVente(),
                        tauxJournalierDeviseDto.getMontantAchat(),
                        tauxJournalierDeviseDto.getDateTaux(),
                        devise));

        return tauxJournalierDeviseOptional.map(tauxJournalierDeviseRepository::save);

    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        tauxJournalierDeviseRepository.deleteById(id);
    }

    @GetMapping
    public Iterable<TauxJournalierDevise> list() {
         return tauxJournalierDeviseRepository.findAll();
    }

}
