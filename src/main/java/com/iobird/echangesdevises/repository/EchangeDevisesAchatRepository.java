package com.iobird.echangesdevises.repository;

import com.iobird.echangesdevises.model.EchangeDevisesAchat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EchangeDevisesAchatRepository extends CrudRepository<EchangeDevisesAchat,Integer> {
}
