package com.example.pokedex.domain.model.entities.response

import java.lang.reflect.Array

data class GetPokemonResponse(
    val abilities : ArrayList<PokemonAbility>,
    val base_experience : Int,
    val height : Int,
    val  id : Int,
    val name : String,
    val sprites : PokemonSprite,
    val weight : Int

)
