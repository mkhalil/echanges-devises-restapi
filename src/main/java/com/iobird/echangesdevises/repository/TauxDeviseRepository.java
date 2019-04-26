package com.iobird.echangesdevises.repository;

import com.iobird.echangesdevises.dto.TauxDeviseDto;
import com.iobird.echangesdevises.model.TauxDevise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TauxDeviseRepository extends JpaRepository<TauxDevise, Long> {

    @Query("SELECT case when count(t) > 0 then true else false end FROM TauxDevise t where t.dateTaux = :#{#taux.dateTaux} AND t.devise.id = :#{#taux.deviseId} ")
    Boolean checkIfExists(@Param("taux") TauxDeviseDto taux);

    List<TauxDevise> findByDateTaux(LocalDate dateTaux);
}
