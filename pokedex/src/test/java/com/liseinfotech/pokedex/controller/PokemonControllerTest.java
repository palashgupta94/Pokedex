package com.liseinfotech.pokedex.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liseinfotech.pokedex.customExceptions.PokemonNotFoundException;
import com.liseinfotech.pokedex.entity.BattleMoves;
import com.liseinfotech.pokedex.entity.Pokemon;
import com.liseinfotech.pokedex.helper.PokemonFactory;

import com.liseinfotech.pokedex.service.serviceInterface.PokemonService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@WebMvcTest(PokemonController.class)
class PokemonControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

//    @MockBean
//    PokemonRepository pokemonRepository;

    @MockBean
    PokemonService pokemonService;

    @Test
    public void getAllRecords_success() throws Exception {
        List<Pokemon> records = PokemonFactory.getPokemons();

        Mockito.when(pokemonService.getAllPokemon()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/pokemon")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name", is("bulba")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name" , is("pikachuuuuuuu")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].battleMoves[0].name" , is("Body Slam")));
    }

    @Test
    public void getAllRecords_empty() throws Exception{

        List<Pokemon> records = new ArrayList<>();

        Mockito.when(pokemonService.getAllPokemon()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/pokemon")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$" , hasSize(0)));


    }

    @Test
    public void getRecordById() throws Exception{

        List<Pokemon> records = PokemonFactory.getPokemons();
        Pokemon pm = records.get(0);

        Mockito.when(pokemonService.getPokemonById(pm.getId())).thenReturn(pm);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/pokemon/{id}" , pm.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.name" , is("pikachuuuuuuu")));

    }

    @Test
    public void getRecordById_empty() throws Exception{

        List<Pokemon> pokemonList = PokemonFactory.getPokemons();
        Pokemon pokemon = pokemonList.get(0);

        Mockito.when(pokemonService.getPokemonById(13)).thenThrow(PokemonNotFoundException.class);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/pokemon/{id}" , 13)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

    }

    @Test
    public void updatePokemon_success() throws Exception{

        Pokemon newPokemon = PokemonFactory.getPokemons().get(0);

        Pokemon updPokemon = getUpdatedPokemon(newPokemon);

        Mockito.when(pokemonService.getPokemonById(newPokemon.getId())).thenReturn(newPokemon);
        Mockito.when(pokemonService.updatePokemon(updPokemon)).thenReturn(updPokemon);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/api/v1/pokemon/13").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON).content(this.objectMapper.writeValueAsString(updPokemon));

        mockMvc.perform(mockRequest).andExpect(status().isOk());
    }

    @Test
    public void updatePokemon_PokemonNotExist() throws Exception{
        Pokemon newPokemon = PokemonFactory.getPokemons().get(0);
        Pokemon updPokemon = getUpdatedPokemon(newPokemon);

        Mockito.when(pokemonService.getPokemonById(newPokemon.getId())).thenReturn(null);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/api/v1/pokemon/13").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON).content(this.objectMapper.writeValueAsString(updPokemon));

        mockMvc.perform(mockRequest).andExpect(status().isNotFound())
                .andExpect(result ->
                        assertTrue(result.getResolvedException() instanceof PokemonNotFoundException
                        )).andExpect(result ->
                assertEquals("Pokemon not found for this : "+ newPokemon.getId(), result.getResolvedException().getMessage()));
    }

    @Test
    public void createPokemon_success() throws Exception{
        Pokemon newPokemon = PokemonFactory.getPokemons().get(1);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/v1/pokemon").contentType(MediaType.APPLICATION_JSON)
          .accept(MediaType.APPLICATION_JSON).content(this.objectMapper.writeValueAsString(newPokemon));

        mockMvc.perform(mockRequest).andExpect(status().isCreated());
    }

    @Test
    public void deletePokemon_success() throws Exception{

        Pokemon pokemon = PokemonFactory.getPokemons().get(0);
        Mockito.when(pokemonService.getPokemonById(pokemon.getId())).thenReturn(pokemon);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/pokemon/{id}", pokemon.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void deletePokemon_whenPokemonDidNotExist() throws Exception {
        Pokemon pokemon = PokemonFactory.getPokemons().get(0);
        Mockito.when(pokemonService.getPokemonById(pokemon.getId())).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/pokemon/{id}", pokemon.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(result ->
                        assertTrue(result.getResolvedException() instanceof PokemonNotFoundException
                        )).andExpect(result ->
                        assertEquals("The pokemon to be deleted with id: " + pokemon.getId() + " Does not exist", result.getResolvedException().getMessage()));

    }

   private Pokemon getUpdatedPokemon(Pokemon newPokemon){
       Pokemon updPokemon = new Pokemon();
       updPokemon.setId(13);
       updPokemon.setName("pika pika");
       updPokemon.setAge(newPokemon.getAge());
       updPokemon.setGender(newPokemon.getGender());
       updPokemon.setDescription(newPokemon.getDescription());
       updPokemon.setBreed(newPokemon.getBreed());
       updPokemon.setImageUrl(newPokemon.getImageUrl());
       newPokemon.getBattleMoves().add(new BattleMoves("Rest" , "Psychic" , "Non-damaging" , "" , ""));
       updPokemon.setBattleMoves(newPokemon.getBattleMoves());
       updPokemon.setNextEvolution("chu chu");

       return updPokemon;
   }
}