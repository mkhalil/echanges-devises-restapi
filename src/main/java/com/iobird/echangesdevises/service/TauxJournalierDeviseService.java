package com.iobird.echangesdevises.service;

import com.iobird.echangesdevises.dto.TauxJournalierDeviseDto;
import com.iobird.echangesdevises.exceptions.BadRequestException;
import com.iobird.echangesdevises.model.Devise;
import com.iobird.echangesdevises.model.TauxJournalierDevise;
import com.iobird.echangesdevises.repository.DeviseRepository;
import com.iobird.echangesdevises.repository.TauxJournalierDeviseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TauxJournalierDeviseService {


    final
    TauxJournalierDeviseRepository tauxJournalierDeviseRepository;

    final
    DeviseRepository deviseRepository;

    @Autowired
    public TauxJournalierDeviseService(TauxJournalierDeviseRepository tauxJournalierDeviseRepository, DeviseRepository deviseRepository) {
        this.tauxJournalierDeviseRepository = tauxJournalierDeviseRepository;
        this.deviseRepository = deviseRepository;
    }

    public Optional<TauxJournalierDevise> update(TauxJournalierDeviseDto tauxJournalierDeviseDto) {
        Optional<TauxJournalierDevise> tauxJournalierDevise = tauxJournalierDeviseRepository.findById(tauxJournalierDeviseDto.getId());
        if (!tauxJournalierDevise.isPresent()) throw new BadRequestException("Taux journalier non trouvé");
        return this.save(tauxJournalierDeviseDto);

    }


    public Optional<TauxJournalierDevise> save(TauxJournalierDeviseDto tauxJournalierDeviseDto) {
        if (tauxJournalierDeviseRepository.checkIfExists(tauxJournalierDeviseDto)) {
            throw new BadRequestException("Taux devise existe déjà");
        }
        Optional<Devise> optionalDevise = deviseRepository.findById(tauxJournalierDeviseDto.getDeviseId());

        if (!optionalDevise.isPresent()) {
            throw new BadRequestException("Devise non trouvé dans la base de données");
        }



        Optional<TauxJournalierDevise> tauxJournalierDeviseOptional = optionalDevise.map(devise ->
                new TauxJournalierDevise(tauxJournalierDeviseDto.getId(),
                        tauxJournalierDeviseDto.getMontantVente(),
                        tauxJournalierDeviseDto.getMontantAchat(),
                        tauxJournalierDeviseDto.getDateTaux(),
                        devise));

        return tauxJournalierDeviseOptional.map(tauxJournalierDeviseRepository::save);
    }

    public void deleteById(Long id) {
        tauxJournalierDeviseRepository.deleteById(id);
    }

    public Iterable<TauxJournalierDevise> iterableList() {
        return tauxJournalierDeviseRepository.findAll();
    }


}
