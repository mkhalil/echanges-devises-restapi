package com.iobird.echangesdevises.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class TauxDeviseDto {

    Long id;

    Long deviseId;

    String abreviation;

    Character symbole;

    Integer unite;

    private BigDecimal montantAchat;

    private BigDecimal montantVente;

    private LocalDate dateTaux;

}