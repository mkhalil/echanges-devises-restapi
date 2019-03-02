package com.iobird.echangesdevises.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue( value = "achat")
public class MotifEchangeAchat extends MotifEchange {

}
