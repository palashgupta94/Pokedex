package com.liseinfotech.pokedex.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liseinfotech.pokedex.entity.Pokemon;
import com.liseinfotech.pokedex.helper.PokemonFactory;

import com.liseinfotech.pokedex.service.serviceInterface.PokemonService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


}