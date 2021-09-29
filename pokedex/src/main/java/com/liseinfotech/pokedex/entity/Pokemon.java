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


    private String name;


    private String gender;


    private int age;


    private String breed;


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

    public Pokemon(int id, String name, String gender, int age, String breed, List<BattleMoves> battleMoves, String nextEvolution, String description, String imageUrl) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.breed = breed;
        this.battleMoves = battleMoves;
        this.nextEvolution = nextEvolution;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
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
                ", pokemonName='" + name + '\'' +
                ", pokemonGender='" + gender + '\'' +
                ", age=" + age +
                ", pokemonBreed='" + breed + '\'' +
                ", battleMoves=" + battleMoves +
                ", nextEvolution='" + nextEvolution + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
