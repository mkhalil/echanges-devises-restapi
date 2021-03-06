package com.iobird.echangesdevises.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TauxDevise")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TauxDevise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    BigDecimal montantVente;

    BigDecimal montantAchat;

    LocalDate dateTaux;

    @ManyToOne
    @JoinColumn(name = "devise_id")
    Devise devise;
}
