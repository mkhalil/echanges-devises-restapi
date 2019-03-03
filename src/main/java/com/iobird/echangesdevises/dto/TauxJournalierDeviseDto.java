package com.iobird.echangesdevises.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class TauxJournalierDeviseDto {

    Long deviseId;

    BigDecimal montantVente;

    BigDecimal montantAchat;

    LocalDate dateTaux;

}
