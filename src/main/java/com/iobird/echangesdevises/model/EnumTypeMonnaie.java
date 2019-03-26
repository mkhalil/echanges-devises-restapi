package com.iobird.echangesdevises.model;

public enum EnumTypeMonnaie {


    BILLET("BILLET"), PIECE("PIECE");

    String name;


    EnumTypeMonnaie(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
