package com.iobird;

import com.iobird.echangesdevises.repository.EchangeDevisesAchatRepository;
import com.iobird.echangesdevises.repository.EchangeDevisesVenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EchangesDevisesRestApiApplication {

    @Autowired
    EchangeDevisesAchatRepository echangeDevisesAchatRepository;


    @Autowired
    EchangeDevisesVenteRepository echangeDevisesVenteRepository;

    public static void main(String[] args) {
        SpringApplication.run(EchangesDevisesRestApiApplication.class, args);
    }


}

