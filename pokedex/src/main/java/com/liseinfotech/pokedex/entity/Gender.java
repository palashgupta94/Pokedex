package com.liseinfotech.pokedex.entity;

public enum  Gender {

    MALE("MALE") ,
    FEMALE("FEMALE"),
    NA("NOT AVAILABLE");

    private String value;

    Gender(String value){

        this.value = value;

    }

}
