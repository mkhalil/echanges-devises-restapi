package com.iobird.echangesdevises.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class EchangeBillet {


    @Id
    Integer id;

    Integer quantite;

    BigDecimal valeur;

    @ManyToOne
    @JoinColumn(name = "devise_id")
    Devise devise;

    @ManyToOne
    @JoinColumn(name = "echange_id")
    EchangeDevises echange;



}
