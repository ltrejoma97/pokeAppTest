package com.example.pokedex.data.repositories

import com.example.pokedex.domain.model.entities.response.GetPokemonResponse
import retrofit2.Call

interface GetPokemonRepository {
    suspend fun getPokemon() : Call<GetPokemonResponse>?
}

class GetPokemonRepositoryImp () : GetPokemonRepository{
    override suspend fun getPokemon(): Call<GetPokemonResponse>? {

        println("hola creaste el repositoryio")
        return null
    }
}