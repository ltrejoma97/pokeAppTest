package com.example.pokedex.data.repositories

import com.example.pokedex.data.EndPoints
import com.example.pokedex.domain.model.entities.GetPokemonListResponse
import retrofit2.Call
import javax.inject.Inject

interface GetPokemonListRepository {
    suspend fun getPokemonList() : Call<GetPokemonListResponse>
}

class GetPokemonListRepositoryImp @Inject constructor(private val endPoints: EndPoints) :GetPokemonListRepository {
    override suspend fun getPokemonList(): Call<GetPokemonListResponse> {
       val response =  endPoints.getPokemonList()
        return response
    }

}