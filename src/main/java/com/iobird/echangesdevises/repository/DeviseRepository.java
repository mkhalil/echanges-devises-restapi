package com.iobird.echangesdevises.repository;

import com.iobird.echangesdevises.model.Devise;
import org.springframework.data.repository.CrudRepository;

public interface DeviseRepository extends CrudRepository<Devise, Long> {
}
