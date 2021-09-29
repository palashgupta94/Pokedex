package com.liseinfotech.pokedex.controller;

import com.liseinfotech.pokedex.customExceptions.PokemonNotFoundException;
import com.liseinfotech.pokedex.entity.Pokemon;
import com.liseinfotech.pokedex.service.serviceInterface.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @PostMapping("/pokemon")
    public ResponseEntity<Pokemon> createPokemon(@RequestBody Pokemon pokemon){
        pokemonService.createPokemon(pokemon);
        return new ResponseEntity<Pokemon>(pokemon , new HttpHeaders() , HttpStatus.OK);
    }

    @GetMapping("/pokemon")
    public ResponseEntity<List<Pokemon>> getAllPokemon(){
        List<Pokemon>list = pokemonService.getAllPokemon();
        return new ResponseEntity<List<Pokemon>>(list , new HttpHeaders() , HttpStatus.OK);
    }

    @GetMapping("/pokemon/{pokemonId}")
    public ResponseEntity<Pokemon>getPokemonById(@PathVariable("pokemonId") int pokemonId) {

        Pokemon pokemon = null;

        try {
            pokemon = pokemonService.getPokemonById(pokemonId);
        } catch (PokemonNotFoundException e) {

            return  new ResponseEntity<>(null , new HttpHeaders() , HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(pokemon , new HttpHeaders() , HttpStatus.OK);
    }

    
    public HttpStatus updatePokemon(){

    }

    @DeleteMapping("/pokemon/{pokemonId}")
    public HttpStatus deletePokemonById(@PathVariable("pokemonId") int id){
        try {
            pokemonService.deletePokemonById(id);
        } catch (PokemonNotFoundException e) {
            return HttpStatus.NOT_FOUND;
        }
        return HttpStatus.OK;
    }



}
