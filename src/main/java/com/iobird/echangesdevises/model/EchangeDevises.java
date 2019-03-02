package com.iobird.echangesdevises.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class EchangeDevises {

    @Id
    @GeneratedValue
    Integer id;

    BigDecimal montantDebit;
    @ManyToOne
    @JoinColumn(name = "devise_debit_id")
    Devise deviseDebit;

    BigDecimal montantCredit;
    @ManyToOne
    @JoinColumn(name = "devise_credit_id")
    Devise deviseCredit;

    BigDecimal cours;

    @OneToMany(mappedBy = "echange")
    List<EchangeBilletCredit> echangeBilletCredits;


    @OneToMany(mappedBy = "echange")
    List<EchangeBilletDebit> echangeBilletDebits;
}
