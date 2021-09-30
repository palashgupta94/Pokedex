package com.liseinfotech.pokedex.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.List;
import com.liseinfotech.pokedex.entity.Stats;

@Entity
@Table(name = "pokemon")
public class Pokemon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private String name;

    private Gender gender;


    private int age;

    private String breed;


    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @JoinColumn
    private List<BattleMoves> battleMoves;

    @ElementCollection(targetClass = PokemonTypeEnum.class)
    @Enumerated(EnumType.STRING)
    private List<PokemonTypeEnum> pokemonType;

    @Column(name = "next_evolution")
    private String nextEvolution;

    private String description;

    private String imageUrl;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @ElementCollection(targetClass = PokemonTypeEnum.class)
    @Enumerated(EnumType.STRING )
    private List<PokemonTypeEnum>weakness;

    @ElementCollection(targetClass = PokemonTypeEnum.class)
    @Enumerated(EnumType.STRING)
    private List<PokemonTypeEnum> Strength;

    private Stats stats;



    public Pokemon() {
    }

    public Pokemon(int id,  String name, Gender gender, int age,  String breed, List<BattleMoves> battleMoves,
                   List<PokemonTypeEnum> pokemonType, String nextEvolution,  String description,
                   String imageUrl, Trainer trainer, List<PokemonTypeEnum> weakness, List<PokemonTypeEnum> strength, Stats stats) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.breed = breed;
        this.battleMoves = battleMoves;
        this.pokemonType = pokemonType;
        this.nextEvolution = nextEvolution;
        this.description = description;
        this.imageUrl = imageUrl;
        this.trainer = trainer;
        this.weakness = weakness;
        Strength = strength;
        this.stats = stats;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
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

    public List<PokemonTypeEnum> getPokemonType() {
        return pokemonType;
    }

    public void setPokemonType(List<PokemonTypeEnum> pokemonType) {
        this.pokemonType = pokemonType;
    }

    public String getNextEvolution() {
        return nextEvolution;
    }

    public void setNextEvolution(String nextEvolution) {
        this.nextEvolution = nextEvolution;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public List<PokemonTypeEnum> getWeakness() {
        return weakness;
    }

    public void setWeakness(List<PokemonTypeEnum> weakness) {
        this.weakness = weakness;
    }

    public List<PokemonTypeEnum> getStrength() {
        return Strength;
    }

    public void setStrength(List<PokemonTypeEnum> strength) {
        Strength = strength;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

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
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", breed='" + breed + '\'' +
                ", battleMoves=" + battleMoves +
                ", pokemonType=" + pokemonType +
                ", nextEvolution='" + nextEvolution + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", trainer=" + trainer +
                ", weakness=" + weakness +
                ", Strength=" + Strength +
                ", stats=" + stats +
                '}';
    }
}
