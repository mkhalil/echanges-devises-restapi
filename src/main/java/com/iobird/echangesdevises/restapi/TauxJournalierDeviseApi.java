package com.iobird.echangesdevises.restapi;

import com.iobird.echangesdevises.dto.TauxJournalierDeviseDto;
import com.iobird.echangesdevises.exceptions.BadRequestException;
import com.iobird.echangesdevises.model.Devise;
import com.iobird.echangesdevises.model.TauxJournalierDevise;
import com.iobird.echangesdevises.repository.DeviseRepository;
import com.iobird.echangesdevises.repository.TauxJournalierDeviseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController("/taux-echanges-devises")
public class TauxJournalierDeviseApi {

    @Autowired
    TauxJournalierDeviseRepository tauxJournalierDeviseRepository;

    @Autowired
    DeviseRepository deviseRepository;


    @PostMapping
    void create(@RequestBody TauxJournalierDeviseDto tauxJournalierDeviseDto) {
        Optional<Devise> optionalDevise = deviseRepository.findById(tauxJournalierDeviseDto.getDeviseId());

        optionalDevise.orElseThrow(() -> new BadRequestException("Devise non trouvé dans la base de données"));
        Optional<TauxJournalierDevise> tauxJournalierDeviseOptional = optionalDevise.map(devise ->
                new TauxJournalierDevise(null,
                        tauxJournalierDeviseDto.getMontantVente(),
                        tauxJournalierDeviseDto.getMontantAchat(),
                        tauxJournalierDeviseDto.getDateTaux(),
                        devise));

        tauxJournalierDeviseOptional.map(tauxJournalierDeviseRepository::save);

    }

    @GetMapping
    public Iterable<TauxJournalierDevise> list() {
         return tauxJournalierDeviseRepository.findAll();
    }

}
