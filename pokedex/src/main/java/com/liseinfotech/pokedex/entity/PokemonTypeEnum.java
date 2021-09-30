package com.liseinfotech.pokedex.entity;

import java.io.Serializable;

public enum PokemonTypeEnum implements Serializable {



    NORMAL("NORMAL") ,
    FIGHTING("FIGHTING") ,
    FLYING("FLYING") ,
    POISON("POISON") ,
    GROUND("GROUND") ,
    ROCK("ROCK") ,
    BUG("BUG") ,
    GHOST("GHOST") ,
    STEEL("STEEL") ,
    FIRE("FIRE") ,
    WATER("WATER") ,
    GRASS("GRASS") ,
    PSYCHIC("PSYCHIC") ,
    ICE("ICE") ,
    DRAGON("DRAGON") ,
    FAIRY("FAIRY") ,
    DARK("DARK"),
    ELECTRIC("ELECTRIC");

    private String value;

    PokemonTypeEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static PokemonTypeEnum fromValue(String val){
        for(PokemonTypeEnum pt: PokemonTypeEnum.values()){
            if(String.valueOf(pt.value).equals(val)) return pt;
        }
        return null;
    }

    public static boolean containsvalue(String value){
        boolean flag = false;
        for(PokemonTypeEnum pte : PokemonTypeEnum.values()){
            if(String.valueOf(pte.value).equals(value)){
                flag = true;
                return flag;
            }
        }
        return flag;
    }
}
