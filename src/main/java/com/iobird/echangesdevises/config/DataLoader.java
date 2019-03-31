package com.iobird.echangesdevises.config;

import com.iobird.echangesdevises.model.Devise;
import com.iobird.echangesdevises.model.Monnaie;
import com.iobird.echangesdevises.model.EnumTypeMonnaie;
import com.iobird.echangesdevises.repository.DeviseMonnaieRepository;
import com.iobird.echangesdevises.repository.DeviseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    DeviseRepository deviseRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Devise deviseEuro = new Devise(null, "EUR", '€', 1, null);

        Monnaie euros100 = new Monnaie(null, "100",  EnumTypeMonnaie.BILLET, deviseEuro);
        Monnaie euros50 = new Monnaie(null, "50",EnumTypeMonnaie.BILLET, deviseEuro);
        Monnaie euros20 = new Monnaie(null, "20",EnumTypeMonnaie.BILLET, deviseEuro);
        Monnaie euros10 = new Monnaie(null, "10",EnumTypeMonnaie.BILLET, deviseEuro);
        Monnaie euros5 = new Monnaie(null, "5",EnumTypeMonnaie.BILLET, deviseEuro);
        Monnaie euros2 = new Monnaie(null, "2",EnumTypeMonnaie.BILLET, deviseEuro);
        Monnaie euros1 = new Monnaie(null, "1",EnumTypeMonnaie.BILLET, deviseEuro);

        Monnaie centime50 = new Monnaie(null, "0.50", EnumTypeMonnaie.PIECE, deviseEuro);
        Monnaie centime20 = new Monnaie(null, "0.20", EnumTypeMonnaie.PIECE, deviseEuro);
        Monnaie centime10 = new Monnaie(null, "0.10", EnumTypeMonnaie.PIECE, deviseEuro);
        Monnaie centime5 = new Monnaie(null, "0.05", EnumTypeMonnaie.PIECE, deviseEuro);
        Monnaie centime2 = new Monnaie(null, "0.02", EnumTypeMonnaie.PIECE, deviseEuro);
        Monnaie centime1 = new Monnaie(null, "0.01", EnumTypeMonnaie.PIECE, deviseEuro);

        List<Monnaie> monnaieList = Arrays.asList(euros100, euros50, euros20, euros10, euros5, euros2, euros1, centime50, centime20, centime10, centime5, centime2, centime1);
        deviseEuro.setMonnaieList(monnaieList);
        deviseRepository.save(deviseEuro);

        Devise deviseDollar = new Devise(null, "Dollar", '$', 1, null);
        deviseRepository.save(deviseDollar);
    }

    @Autowired
    DeviseMonnaieRepository deviseMonnaieRepository;
}
