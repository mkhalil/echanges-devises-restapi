package com.iobird.echangesdevises.repository;

import com.iobird.echangesdevises.model.EchangeDevisesVente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EchangeDevisesVenteRepository extends CrudRepository<EchangeDevisesVente, Integer> {
}
