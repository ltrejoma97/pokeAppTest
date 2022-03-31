package com.example.pokedex.domain.model.entities

data class GetPokemonListResponse(
    val count : String,
    val next : String ,
    val previous: String,
    val results : ArrayList<Pokemon>
   )