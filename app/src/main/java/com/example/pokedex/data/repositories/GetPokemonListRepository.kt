package com.example.pokedex.data.repositories

import com.example.pokedex.domain.model.entities.GetPokemonListResponse
import retrofit2.Call

interface GetPokemonListRepository {
    suspend fun getPokemonList() : Call<GetPokemonListResponse>?
}

class GetPokemonListRepositoryImp() :GetPokemonListRepository {
    override suspend fun getPokemonList(): Call<GetPokemonListResponse>? {
        println("hola el repositorio funciona")
        return null
    }

}