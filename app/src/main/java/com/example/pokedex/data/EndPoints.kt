package com.example.pokedex.data

import com.example.pokedex.domain.model.entities.GetPokemonListResponse
import dagger.Provides
import retrofit2.Call
import retrofit2.http.GET

interface EndPoints {

    @GET("pokemon?limit=100&offset=200")
    fun getPokemonList(): Call<GetPokemonListResponse>
}