package com.iobird.echangesdevises.config;

import com.iobird.echangesdevises.dto.TauxDeviseDto;
import com.iobird.echangesdevises.model.Devise;
import com.iobird.echangesdevises.model.EnumTypeMonnaie;
import com.iobird.echangesdevises.model.Monnaie;
import com.iobird.echangesdevises.repository.DeviseMonnaieRepository;
import com.iobird.echangesdevises.repository.DeviseRepository;
import com.iobird.echangesdevises.service.TauxDeviseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    DeviseRepository deviseRepository;
    @Autowired
    TauxDeviseService tauxDeviseService;
    @Autowired
    DeviseMonnaieRepository deviseMonnaieRepository;

    @Override
    public void run(ApplicationArguments args) {
        Devise deviseEuro = new Devise(null, "EUR", '€', 1, null);

        Monnaie euros100 = new Monnaie(null, "100", EnumTypeMonnaie.BILLET, deviseEuro);
        Monnaie euros50 = new Monnaie(null, "50", EnumTypeMonnaie.BILLET, deviseEuro);
        Monnaie euros20 = new Monnaie(null, "20", EnumTypeMonnaie.BILLET, deviseEuro);
        Monnaie euros10 = new Monnaie(null, "10", EnumTypeMonnaie.BILLET, deviseEuro);
        Monnaie euros5 = new Monnaie(null, "5", EnumTypeMonnaie.BILLET, deviseEuro);

        Monnaie euros2 = new Monnaie(null, "2", EnumTypeMonnaie.PIECE, deviseEuro);
        Monnaie euros1 = new Monnaie(null, "1", EnumTypeMonnaie.PIECE, deviseEuro);
        Monnaie centime50 = new Monnaie(null, "0.50", EnumTypeMonnaie.PIECE, deviseEuro);
        Monnaie centime20 = new Monnaie(null, "0.20", EnumTypeMonnaie.PIECE, deviseEuro);
        Monnaie centime10 = new Monnaie(null, "0.10", EnumTypeMonnaie.PIECE, deviseEuro);
        Monnaie centime5 = new Monnaie(null, "0.05", EnumTypeMonnaie.PIECE, deviseEuro);
        Monnaie centime2 = new Monnaie(null, "0.02", EnumTypeMonnaie.PIECE, deviseEuro);
        Monnaie centime1 = new Monnaie(null, "0.01", EnumTypeMonnaie.PIECE, deviseEuro);

        List<Monnaie> monnaieList = Arrays.asList(euros100, euros50, euros20, euros10, euros5, euros2, euros1, centime50, centime20, centime10, centime5, centime2, centime1);
        deviseEuro.setMonnaies(monnaieList);
        deviseRepository.save(deviseEuro);

        Devise deviseDollar = new Devise(null, "Dollar", '$', 1, null);
        deviseRepository.save(deviseDollar);

        addCurrentTauxDevise();
    }

    private void addCurrentTauxDevise() {
        TauxDeviseDto tauxEuro = new TauxDeviseDto();
        tauxEuro.setDeviseId(1L);
        tauxEuro.setDateTaux(LocalDate.now());
        tauxEuro.setMontantAchat(BigDecimal.valueOf(2.5));
        tauxEuro.setMontantVente(BigDecimal.valueOf(2.7));
        tauxDeviseService.save(tauxEuro);
        TauxDeviseDto tauxDollar = new TauxDeviseDto();
        tauxDollar.setDeviseId(2L);
        tauxDollar.setDateTaux(LocalDate.now());
        tauxDollar.setMontantAchat(BigDecimal.valueOf(1.4));
        tauxDollar.setMontantVente(BigDecimal.valueOf(1.7));
        tauxDeviseService.save(tauxDollar);
    }
}
