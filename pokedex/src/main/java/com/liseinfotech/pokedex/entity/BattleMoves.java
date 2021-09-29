package com.liseinfotech.pokedex.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class BattleMoves implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String type;
    private String category;
    private String power;
    private String accuracy;


    public BattleMoves() {
    }

    public BattleMoves(String name, String type, String category, String power, String accuracy) {
        this.name = name;
        this.type = type;
        this.category = category;
        this.power = power;
        this.accuracy = accuracy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    @Override
    public String toString() {
        return "BattleMoves{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", category='" + category + '\'' +
                ", power='" + power + '\'' +
                ", accuracy='" + accuracy + '\'' +
                '}';
    }
}
