package com.iobird.echangesdevises.repository;

import com.iobird.echangesdevises.model.Monnaie;
import org.springframework.data.repository.CrudRepository;

public interface DeviseMonnaieRepository extends CrudRepository<Monnaie, Long> {
}
