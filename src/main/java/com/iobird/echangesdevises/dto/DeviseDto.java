package com.iobird.echangesdevises.dto;

import com.iobird.echangesdevises.model.Monnaie;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeviseDto {

    Long id;

    String abreviation;

    Character symbole;

    Integer unite;

    List<Monnaie> monnaies;
}
