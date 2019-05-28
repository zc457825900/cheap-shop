package com.perfect.cheapshop.enums;

public enum Gender {
    MAN(1),WOMAN(2);
    private final int value;
    Gender(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
