package com.iobird.echangesdevises.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("debit")
public class EchangeBilletDebit extends EchangeBillet {
}
