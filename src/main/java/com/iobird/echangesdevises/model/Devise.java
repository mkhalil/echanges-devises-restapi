package com.iobird.echangesdevises.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    Character symbole;

    Integer unite;


    @OneToMany(mappedBy = "devise", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    List<Monnaie> monnaieList;

}
