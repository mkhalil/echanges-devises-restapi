package com.iobird.echangesdevises.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
public class FicheClient {

    @Id
    @GeneratedValue
    private Integer id;

    private String nom;


}
