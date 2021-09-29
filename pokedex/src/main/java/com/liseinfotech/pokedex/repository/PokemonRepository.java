package com.liseinfotech.pokedex.repository;

import com.liseinfotech.pokedex.entity.Pokemon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon , Integer> {

}
