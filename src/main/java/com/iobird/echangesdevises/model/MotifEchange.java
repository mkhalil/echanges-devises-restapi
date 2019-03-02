package com.iobird.echangesdevises.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class MotifEchange {

    @Id
    @GeneratedValue
    Integer id;

    String description;
}
