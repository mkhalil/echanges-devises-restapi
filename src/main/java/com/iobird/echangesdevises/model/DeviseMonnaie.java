package com.iobird.echangesdevises.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeviseMonnaie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String valeur;

    String typeValeur;


    @Enumerated(EnumType.STRING)
    EnumTypeMonnaie type;

    @ManyToOne
    @JoinColumn(name = "devise_id")
    Devise devise;


}
