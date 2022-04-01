package com.example.pokedex.domain.usecase

import com.example.pokedex.data.repositories.GetPokemonRepository
import com.example.pokedex.domain.model.entities.response.GetPokemonResponse
import retrofit2.await
import javax.inject.Inject

interface GetPokemonUseCase {
    suspend fun invoke(urlOfPokemon: String): GetPokemonResponse
}

class GetPokemonUseCaseImp @Inject constructor(private val repository: GetPokemonRepository) : GetPokemonUseCase {
    override suspend fun invoke(urlOfPokemon: String): GetPokemonResponse {
       val pokemonResponse = repository.getPokemon(urlOfPokemon).await()
        return pokemonResponse
    }
}