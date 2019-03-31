package com.iobird.echangesdevises.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Monnaie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String valeur;

    @Enumerated(EnumType.STRING)
    EnumTypeMonnaie type;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "devise_id")
    Devise devise;


}
