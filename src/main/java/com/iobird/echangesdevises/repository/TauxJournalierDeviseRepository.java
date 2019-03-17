package com.iobird.echangesdevises.repository;

import com.iobird.echangesdevises.dto.TauxJournalierDeviseDto;
import com.iobird.echangesdevises.model.TauxJournalierDevise;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface TauxJournalierDeviseRepository extends CrudRepository<TauxJournalierDevise, Long> {

    @Query("SELECT case when count(t) > 0 then true else false end FROM TauxJournalierDevise t where t.dateTaux = :#{#taux.dateTaux} AND t.devise.id = :#{#taux.deviseId} ")
    Boolean checkIfExists(@Param("taux") TauxJournalierDeviseDto taux);

    Iterable<TauxJournalierDevise> findByDateTaux(LocalDate dateTaux);
}
