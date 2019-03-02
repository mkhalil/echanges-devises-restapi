package com.iobird.echangesdevises.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("credit")
public class EchangeBilletCredit extends EchangeBillet {
}
