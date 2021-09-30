package com.liseinfotech.pokedex.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Trainer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trainer_id")
    private int trainerId;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String region;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY )
    private List<Achievement> achievements;

    private int noOfLosses;

    private int noOfWins;

    @OneToMany(mappedBy = "trainer" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<Pokemon> pokemons;

    public Trainer() {
    }

    public Trainer(int trainerId, String name, Gender gender, String region, List<Achievement> achievements, int noOfLosses, int noOfWins, List<Pokemon> pokemons) {
        this.trainerId = trainerId;
        this.name = name;
        this.gender = gender;
        this.region = region;
        this.achievements = achievements;
        this.noOfLosses = noOfLosses;
        this.noOfWins = noOfWins;
        this.pokemons = pokemons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<Achievement> achievements) {
        this.achievements = achievements;
    }

    public int getNoOfLosses() {
        return noOfLosses;
    }

    public void setNoOfLosses(int noOfLosses) {
        this.noOfLosses = noOfLosses;
    }

    public int getNoOfWins() {
        return noOfWins;
    }

    public void setNoOfWins(int noOfWins) {
        this.noOfWins = noOfWins;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "trainerId=" + trainerId +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", region='" + region + '\'' +
                ", achievements=" + achievements +
                ", noOfLosses=" + noOfLosses +
                ", noOfWins=" + noOfWins +
                ", pokemons=" + pokemons +
                '}';
    }
}
