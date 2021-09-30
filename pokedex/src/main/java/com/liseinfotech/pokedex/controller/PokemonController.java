package com.liseinfotech.pokedex.controller;

import com.liseinfotech.pokedex.customExceptions.PokemonNotFoundException;
import com.liseinfotech.pokedex.entity.Pokemon;

import com.liseinfotech.pokedex.service.serviceInterface.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Validated
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>("Some of the values for the properties are not valid because " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/pokemon")
    public ResponseEntity<Pokemon> createPokemon(@RequestBody Pokemon pokemon){
        pokemonService.createPokemon(pokemon);
        return new ResponseEntity<Pokemon>(pokemon , new HttpHeaders() , HttpStatus.CREATED);
    }

    @GetMapping("/pokemon")
    public ResponseEntity<List<Pokemon>> getAllPokemon(){
        List<Pokemon>list = pokemonService.getAllPokemon();
//        List<Pokemon> list = (List<Pokemon>) pokemonRepository.findAll();
        return new ResponseEntity<List<Pokemon>>(list , new HttpHeaders() , HttpStatus.OK);
    }

    @GetMapping("/pokemon/{pokemonId}")
    public ResponseEntity<Pokemon>getPokemonById(@PathVariable("pokemonId") int pokemonId) throws PokemonNotFoundException, Exception {

        Pokemon pokemon = pokemonService.getPokemonById(pokemonId);
        if (pokemon==null){
            throw new PokemonNotFoundException(" Pokemon not found for this id : "+ pokemonId);
        }
        return new ResponseEntity<>(pokemon , new HttpHeaders() , HttpStatus.OK);
    }

    @PutMapping("/pokemon/{pokemonId}")
    public ResponseEntity<Pokemon> updatePokemon(@PathVariable("pokemonId") int pokemonId , @RequestBody Pokemon pokemon) throws PokemonNotFoundException {

        HttpStatus status = HttpStatus.BAD_REQUEST;
        Pokemon actPokemon = null;
        Pokemon updatedPokemon = null;

        actPokemon = pokemonService.getPokemonById(pokemonId);
        if (actPokemon != null) {
            actPokemon.setId(pokemonId);
            actPokemon.setName(pokemon.getName());
            actPokemon.setGender(pokemon.getGender());
            actPokemon.setAge(pokemon.getAge());
            actPokemon.setBreed(pokemon.getBreed());
            actPokemon.setBattleMoves(pokemon.getBattleMoves());
            actPokemon.setNextEvolution(pokemon.getNextEvolution());
            actPokemon.setDescription(pokemon.getDescription());
            actPokemon.setImageUrl(pokemon.getImageUrl());

            updatedPokemon = pokemonService.updatePokemon(actPokemon);
            status = HttpStatus.OK;
        } else {
            throw new PokemonNotFoundException("Pokemon not found for this : "+ pokemonId);
        }
        return new ResponseEntity<>(updatedPokemon , new HttpHeaders() , status);
    }

    @DeleteMapping("/pokemon/{pokemonId}")
    public HttpStatus deletePokemonById(@PathVariable("pokemonId") int id) throws PokemonNotFoundException,Exception {
            Pokemon pokemon = pokemonService.getPokemonById(id);
            if (pokemon!=null){
                pokemonService.deletePokemonById(id);
                return HttpStatus.OK;
            } else {
                throw new PokemonNotFoundException("The pokemon to be deleted with id: " + id + " Does not exist");
            }
    }

}
