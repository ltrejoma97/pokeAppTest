package com.example.pokedex.data

import com.example.pokedex.domain.model.entities.GetPokemonListResponse
import com.example.pokedex.domain.model.entities.response.GetPokemonResponse
import com.google.gson.JsonObject
import dagger.Provides
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface EndPoints {

    @GET("pokemon?limit=100&offset=200")
    fun getPokemonList(): Call<GetPokemonListResponse>

    @GET("{pokemonId}/")
    fun getPokemon(@Path("pokemonId") pokemonId: String): Call<GetPokemonResponse>
}

//interface LanguageNamespaceApiDataSource {
//    @GET("/{projectId}/{version}/{language}/{namespace}")
//    suspend fun getNamespace(
//        @Path("projectId") projectId: String,
//        @Path("version") version: String,
//        @Path("language") language: String,
//        @Path("namespace") namespace: String
//    ): Response<JsonObject?>
//}