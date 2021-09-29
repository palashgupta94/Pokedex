package com.liseinfotech.pokedex.service.serviceInterfaceImpl;

import com.liseinfotech.pokedex.customExceptions.PokemonNotFoundException;
import com.liseinfotech.pokedex.entity.Pokemon;
import com.liseinfotech.pokedex.repository.PokemonRepository;
import com.liseinfotech.pokedex.service.serviceInterface.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonServiceImpl implements PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Override
    public List<Pokemon> getAllPokemon() {

        return (List<Pokemon>) pokemonRepository.findAll();
    }

    @Override
    public void createPokemon(Pokemon pokemon) {

        pokemonRepository.save(pokemon);
    }

    @Override
    public Pokemon getPokemonById(int pokemonId) {

        Pokemon pokemon = null;
        Optional<Pokemon> optional = pokemonRepository.findById(pokemonId);
        if(optional.isPresent()){
            pokemon = optional.get();
        }
        return pokemon;

    }

    @Override
    public Pokemon updatePokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    @Override
    public void deletePokemonById(int pokemonId) throws PokemonNotFoundException {
//
        try {
            pokemonRepository.deleteById(pokemonId);
        } catch (EmptyResultDataAccessException e) {
            throw new PokemonNotFoundException("Pokemon not found for this id : "+ pokemonId +" to delete");
        }

    }
}
