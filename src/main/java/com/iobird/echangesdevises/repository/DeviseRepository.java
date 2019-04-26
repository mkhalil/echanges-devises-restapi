package com.iobird.echangesdevises.repository;

import com.iobird.echangesdevises.model.Devise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviseRepository extends JpaRepository<Devise, Long> {
}
