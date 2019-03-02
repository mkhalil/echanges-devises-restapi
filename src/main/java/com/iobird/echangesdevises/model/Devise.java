package com.iobird.echangesdevises.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Devise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String abreviation;

    Integer unite;


}
