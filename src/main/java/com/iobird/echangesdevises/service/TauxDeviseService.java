package com.iobird.echangesdevises.service;

import com.iobird.echangesdevises.dto.DtoMapper;
import com.iobird.echangesdevises.dto.TauxDeviseDto;
import com.iobird.echangesdevises.exceptions.BadRequestException;
import com.iobird.echangesdevises.exceptions.ResourceNotFoundException;
import com.iobird.echangesdevises.model.Devise;
import com.iobird.echangesdevises.model.TauxDevise;
import com.iobird.echangesdevises.repository.DeviseRepository;
import com.iobird.echangesdevises.repository.TauxDeviseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TauxDeviseService {


    private final
    TauxDeviseRepository tauxDeviseRepository;

    private final
    DeviseRepository deviseRepository;

    @Autowired
    public TauxDeviseService(TauxDeviseRepository tauxDeviseRepository, DeviseRepository deviseRepository) {
        this.tauxDeviseRepository = tauxDeviseRepository;
        this.deviseRepository = deviseRepository;
    }

    public Optional<TauxDevise> update(TauxDeviseDto tauxJournalierDeviseDto) {
        return this.flush(tauxJournalierDeviseDto);
    }

    private Optional<TauxDevise> flush(TauxDeviseDto tauxJournalierDeviseDto) {

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

        return tauxJournalierDeviseOptional.map(tauxDeviseRepository::save);
    }

    public Optional<TauxDevise> save(TauxDeviseDto tauxJournalierDeviseDto) {
        if (tauxDeviseRepository.checkIfExists(tauxJournalierDeviseDto)) {
            throw new BadRequestException("Taux existe déjà !");
        }
        return this.flush(tauxJournalierDeviseDto);

    }

    public void deleteById(Long id) {
        tauxDeviseRepository.deleteById(id);
    }

    public List<TauxDeviseDto> search(LocalDate dateTaux) {
        List<TauxDevise> tauxDevises = Optional.ofNullable(dateTaux).map(tauxDeviseRepository::findByDateTaux).orElse(tauxDeviseRepository.findAll());
        if (CollectionUtils.isEmpty(tauxDevises)) {
            throw new ResourceNotFoundException("Aucun taux trouvés");
        }
        return tauxDevises.stream().map(DtoMapper.INSTANCE::toDto).collect(Collectors.toList());
    }


}
