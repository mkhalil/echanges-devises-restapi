package com.iobird.echangesdevises.service;

import com.iobird.echangesdevises.dto.TauxJournalierDeviseDto;
import com.iobird.echangesdevises.exceptions.BadRequestException;
import com.iobird.echangesdevises.model.Devise;
import com.iobird.echangesdevises.model.TauxDevise;
import com.iobird.echangesdevises.repository.DeviseRepository;
import com.iobird.echangesdevises.repository.TauxJournalierDeviseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class TauxDeviseService {


    final
    TauxJournalierDeviseRepository tauxJournalierDeviseRepository;

    final
    DeviseRepository deviseRepository;

    @Autowired
    public TauxDeviseService(TauxJournalierDeviseRepository tauxJournalierDeviseRepository, DeviseRepository deviseRepository) {
        this.tauxJournalierDeviseRepository = tauxJournalierDeviseRepository;
        this.deviseRepository = deviseRepository;
    }

    public Optional<TauxDevise> update(TauxJournalierDeviseDto tauxJournalierDeviseDto) {
        return this.flush(tauxJournalierDeviseDto);
    }

    private Optional<TauxDevise> flush(TauxJournalierDeviseDto tauxJournalierDeviseDto) {

        Optional<Devise> optionalDevise = deviseRepository.findById(tauxJournalierDeviseDto.getDeviseId());

        if (!optionalDevise.isPresent()) {
            throw new BadRequestException("Devise non trouvé dans la base de données");
        }



        Optional<TauxDevise> tauxJournalierDeviseOptional = optionalDevise.map(devise ->
                new TauxDevise(tauxJournalierDeviseDto.getId(),
                        tauxJournalierDeviseDto.getMontantVente(),
                        tauxJournalierDeviseDto.getMontantAchat(),
                        tauxJournalierDeviseDto.getDateTaux(),
                        devise));

        return tauxJournalierDeviseOptional.map(tauxJournalierDeviseRepository::save);
    }

    public Optional<TauxDevise> save(TauxJournalierDeviseDto tauxJournalierDeviseDto) {
        if (tauxJournalierDeviseRepository.checkIfExists(tauxJournalierDeviseDto)) {
            throw new BadRequestException("Taux existe déjà !");
        }
        return this.flush(tauxJournalierDeviseDto);

    }

    public void deleteById(Long id) {
        tauxJournalierDeviseRepository.deleteById(id);
    }

    public Iterable<TauxDevise> iterableList() {
        return tauxJournalierDeviseRepository.findAll();
    }



    public Iterable<TauxDevise> currentTaux(LocalDate dateTaux) {
        return tauxJournalierDeviseRepository.findByDateTaux(dateTaux);
    }
}
