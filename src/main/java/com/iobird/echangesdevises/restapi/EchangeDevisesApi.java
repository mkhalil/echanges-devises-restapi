package com.iobird.echangesdevises.restapi;

import com.iobird.echangesdevises.model.EchangeDevisesAchat;
import com.iobird.echangesdevises.model.MotifEchangeAchat;
import com.iobird.echangesdevises.repository.EchangeDevisesAchatRepository;
import com.iobird.echangesdevises.repository.MotifEchangeAchatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchangeDevisesApi {

    @Autowired
    MotifEchangeAchatRepository motifEchangeAchatRepository;

    @Autowired
    EchangeDevisesAchatRepository echangeDevisesAchatRepository;

    @PostMapping("/motifEchangeAchat")
    MotifEchangeAchat newMotifEchangeAchat(@RequestBody MotifEchangeAchat motifEchangeAchat) {
        return motifEchangeAchatRepository.save(motifEchangeAchat);
    }

    @PostMapping("/echangeDeviseAchat")
    EchangeDevisesAchat newEchangeDevisesAchat(@RequestBody EchangeDevisesAchat echangeDevisesAchat) {

        return echangeDevisesAchatRepository.save(echangeDevisesAchat);
    }
}
