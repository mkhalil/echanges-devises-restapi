package com.iobird.echangesdevises.config;

import com.iobird.echangesdevises.model.Devise;
import com.iobird.echangesdevises.repository.DeviseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    DeviseRepository deviseRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Devise deviseEuro = new Devise(null, "EUR", Character.valueOf('€'), 1);
        deviseRepository.save(deviseEuro);

        Devise deviseDollar = new Devise(null, "Dollar",  Character.valueOf('$'), 1);
        deviseRepository.save(deviseDollar);
    }
}
