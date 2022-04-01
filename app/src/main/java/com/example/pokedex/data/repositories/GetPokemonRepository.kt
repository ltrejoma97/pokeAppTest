package com.example.pokedex.data.repositories

import com.example.pokedex.data.EndPoints
import com.example.pokedex.domain.model.entities.response.GetPokemonResponse
import retrofit2.Call
import javax.inject.Inject

interface GetPokemonRepository {
    suspend fun getPokemon(urlOfPokemon: String): Call<GetPokemonResponse>
}

class GetPokemonRepositoryImp @Inject constructor(private val endPoints: EndPoints) : GetPokemonRepository{
    override suspend fun getPokemon(urlOfPokemon: String): Call<GetPokemonResponse>{
        val pokemonResponse = endPoints.getPokemon(urlOfPokemon)
        return pokemonResponse
    }
}