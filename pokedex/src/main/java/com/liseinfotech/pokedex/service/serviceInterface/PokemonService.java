package com.liseinfotech.pokedex.service.serviceInterface;


import com.liseinfotech.pokedex.customExceptions.PokemonNotFoundException;
import com.liseinfotech.pokedex.entity.Pokemon;

import java.util.List;

public interface PokemonService {

    List<Pokemon> getAllPokemon();
    void createPokemon(Pokemon pokemon);
    Pokemon getPokemonById(int pokemonId) throws PokemonNotFoundException;
    Pokemon updatePokemon(Pokemon pokemon);
    void deletePokemonById(int pokemonId) throws PokemonNotFoundException;
}
