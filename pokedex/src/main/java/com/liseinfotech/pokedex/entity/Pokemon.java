package com.liseinfotech.pokedex.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "pokemon")
public class Pokemon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private String pokemonName;


    private String pokemonGender;


    private int age;


    private String pokemonBreed;


    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinColumn
    private List<BattleMoves> battleMoves;
//
//    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
//    @JoinColumn(name = "pokemon_id")
//    private List<PokemonTypeEnum>pokemonType;

    @Column(name = "next_evolution")
    private String nextEvolution;

    private String description;

    private String imageUrl;

    public Pokemon() {
    }

    public Pokemon(int id, String pokemonName, String pokemonGender, int age, String pokemonBreed, List<BattleMoves> battleMoves,
                   List<PokemonTypeEnum> pokemonType, String nextEvolution, Map<String, String> battleStats , String description,
                    String imageUrl) {
        this.id = id;
        this.pokemonName = pokemonName;
        this.pokemonGender = pokemonGender;
        this.age = age;
        this.pokemonBreed = pokemonBreed;
        this.battleMoves = battleMoves;
//        this.pokemonType = pokemonType;
        this.nextEvolution = nextEvolution;
//        this.battleStats = battleStats;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public String getPokemonGender() {
        return pokemonGender;
    }

    public void setPokemonGender(String pokemonGender) {
        this.pokemonGender = pokemonGender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPokemonBreed() {
        return pokemonBreed;
    }

    public void setPokemonBreed(String pokemonBreed) {
        this.pokemonBreed = pokemonBreed;
    }

    public List<BattleMoves> getBattleMoves() {
        return battleMoves;
    }

    public void setBattleMoves(List<BattleMoves> battleMoves) {
        this.battleMoves = battleMoves;
    }

//    public List<PokemonType> getPokemonType() {
//        return pokemonType;
//    }
//
//    public void setPokemonType(List<PokemonType> pokemonType) {
//        this.pokemonType = pokemonType;
//    }

    public String getNextEvolution() {
        return nextEvolution;
    }

    public void setNextEvolution(String nextEvolution) {
        this.nextEvolution = nextEvolution;
    }

//    public Map<String, String> getBattleStats() {
//        return battleStats;
//    }
//
//    public void setBattleStats(Map<String, String> battleStats) {
//        this.battleStats = battleStats;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", pokemonName='" + pokemonName + '\'' +
                ", pokemonGender='" + pokemonGender + '\'' +
                ", age=" + age +
                ", pokemonBreed='" + pokemonBreed + '\'' +
                ", battleMoves=" + battleMoves +
                ", nextEvolution='" + nextEvolution + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
