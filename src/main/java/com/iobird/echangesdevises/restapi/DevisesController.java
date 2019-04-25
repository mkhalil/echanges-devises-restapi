package com.iobird.echangesdevises.restapi;

import com.iobird.echangesdevises.model.Devise;
import com.iobird.echangesdevises.repository.DeviseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/devises", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class DevisesController {

    @Autowired
    DeviseRepository deviseRepository;


    @GetMapping
    public Iterable<Devise> list() {
        return deviseRepository.findAll();
    }


    @GetMapping("/{id}")
    public Optional<Devise> monnaies(@PathVariable("id") Long id) {
        return deviseRepository.findById(id);
    }


}
