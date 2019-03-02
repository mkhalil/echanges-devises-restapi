package com.iobird.echangesdevises.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue( value = "vente")
public class MotifEchangeVente extends MotifEchange {

}
