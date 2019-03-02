package com.iobird.echangesdevises.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table
@Getter
@Setter
@Entity
public class EchangeDevisesAchat extends EchangeDevises {

    @ManyToOne
    @JoinColumn(name = "motif_achat_id")
    MotifEchangeAchat motifAchat;
}
