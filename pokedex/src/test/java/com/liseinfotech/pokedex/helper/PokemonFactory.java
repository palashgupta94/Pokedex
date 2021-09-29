package com.liseinfotech.pokedex.helper;

import com.liseinfotech.pokedex.entity.BattleMoves;
import com.liseinfotech.pokedex.entity.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class PokemonFactory {

    public static List<Pokemon> getPokemons(){

        List<Pokemon> pokemonList = new ArrayList<>();

        Pokemon pm1 = new Pokemon();
        pm1.setId(13);
        pm1.setName("pikachuuuuuuu");
        pm1.setGender("maleeee");
        pm1.setAge(2222);
        pm1.setBreed("Pikachu");

        List<BattleMoves>battleMovesList1 = new ArrayList<>();
        BattleMoves bm1 = new BattleMoves();
        bm1.setName("Body Slam");
        bm1.setType("Normal");
        bm1.setCategory("Physical");
        bm1.setPower("85 BP");
        bm1.setAccuracy("100 %");
        battleMovesList1.add(bm1);

        BattleMoves bm2 = new BattleMoves();
        bm2.setName("Thunder shock");
        bm2.setType("Electric");
        bm2.setCategory("Special");
        bm2.setPower("40 BP");
        bm2.setAccuracy("100 %");
        battleMovesList1.add(bm2);

        BattleMoves bm3 = new BattleMoves();
        bm3.setName("Iron Trail");
        bm3.setType("Steel");
        bm3.setCategory("Physical");
        bm3.setPower("100 BP");
        bm3.setAccuracy("75 %");

        battleMovesList1.add(bm3);

        pm1.setBattleMoves(battleMovesList1);
        pm1.setNextEvolution("Raichu");
        pm1.setDescription("favorite of all Ash pokemons and always sits on Ash's shoulder like an owl");
        pm1.setImageUrl("https://cdn2.bulbagarden.net/upload/4/49/Ash_Pikachu.png");

        pokemonList.add(pm1);

        Pokemon pm2 = new Pokemon();
        pm2.setName("bulba");
        pm2.setGender("male");
        pm2.setAge(2);
        pm2.setBreed("Bulbasaur");

        List<BattleMoves>battleMovesList2 = new ArrayList<>();
        BattleMoves bm4 = new BattleMoves();
        bm4.setName("Body Slam");
        bm4.setType("Normal");
        bm4.setCategory("Physical");
        bm4.setPower("85 BP");
        bm4.setAccuracy("100 %");
        battleMovesList1.add(bm4);

        BattleMoves bm5 = new BattleMoves();
        bm5.setName("Razor Leaf");
        bm5.setType("Grass");
        bm5.setCategory("Special");
        bm5.setPower("55 BP");
        bm5.setAccuracy("95 %");
        battleMovesList1.add(bm5);



        pm2.setBattleMoves(battleMovesList2);
        pm2.setNextEvolution("Ivysaur");
        pm2.setDescription("leader of all Ash pokemons");
        pm2.setImageUrl("https://cdn2.bulbagarden.net/upload/2/21/001Bulbasaur.png");

        pokemonList.add(pm2);

        return pokemonList;
    }

}
