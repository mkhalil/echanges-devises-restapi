package com.iobird.echangesdevises.config;

import com.iobird.echangesdevises.model.Devise;
import com.iobird.echangesdevises.model.DeviseMonnaie;
import com.iobird.echangesdevises.model.EnumTypeMonnaie;
import com.iobird.echangesdevises.repository.DeviseMonnaieRepository;
import com.iobird.echangesdevises.repository.DeviseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    DeviseRepository deviseRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Devise deviseEuro = new Devise(null, "EUR", '€', 1);
        deviseRepository.save(deviseEuro);

        DeviseMonnaie euros100 = new DeviseMonnaie(null, "100", "Euro", EnumTypeMonnaie.BILLET, deviseEuro);
        DeviseMonnaie euros50 = new DeviseMonnaie(null, "50", "Euro", EnumTypeMonnaie.BILLET, deviseEuro);
        DeviseMonnaie euros20 = new DeviseMonnaie(null, "20", "Euro", EnumTypeMonnaie.BILLET, deviseEuro);
        DeviseMonnaie euros10 = new DeviseMonnaie(null, "10", "Euro", EnumTypeMonnaie.BILLET, deviseEuro);
        DeviseMonnaie euros5 = new DeviseMonnaie(null, "5", "Euro", EnumTypeMonnaie.BILLET, deviseEuro);
        DeviseMonnaie euros2 = new DeviseMonnaie(null, "2", "Euro", EnumTypeMonnaie.BILLET, deviseEuro);
        DeviseMonnaie euros1 = new DeviseMonnaie(null, "1", "Euro", EnumTypeMonnaie.BILLET, deviseEuro);

        DeviseMonnaie centime50 = new DeviseMonnaie(null, "50", "Centime", EnumTypeMonnaie.PIECE, deviseEuro);
        DeviseMonnaie centime20 = new DeviseMonnaie(null, "20", "Centime", EnumTypeMonnaie.PIECE, deviseEuro);
        DeviseMonnaie centime10 = new DeviseMonnaie(null, "10", "Centime", EnumTypeMonnaie.PIECE, deviseEuro);
        DeviseMonnaie centime5 = new DeviseMonnaie(null, "5", "Centime", EnumTypeMonnaie.PIECE, deviseEuro);
        DeviseMonnaie centime2 = new DeviseMonnaie(null, "2", "Centime", EnumTypeMonnaie.PIECE, deviseEuro);
        DeviseMonnaie centime1 = new DeviseMonnaie(null, "1", "Centime", EnumTypeMonnaie.PIECE, deviseEuro);

        deviseMonnaieRepository.saveAll(Arrays.asList(euros100, euros50, euros20, euros10, euros5, euros2, euros1, centime50, centime20, centime10, centime5, centime2, centime1));

        Devise deviseDollar = new Devise(null, "Dollar", '$', 1);
        deviseRepository.save(deviseDollar);
    }

    @Autowired
    DeviseMonnaieRepository deviseMonnaieRepository;
}
