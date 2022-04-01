package com.example.pokedex.domain.usecase

import com.example.pokedex.data.repositories.GetPokemonRepository
import com.example.pokedex.domain.model.entities.response.GetPokemonResponse
import javax.inject.Inject

interface GetPokemonUseCase {
    suspend fun invoke () : GetPokemonResponse?
}

class GetPokemonUseCaseImp @Inject constructor(private val repository: GetPokemonRepository) : GetPokemonUseCase {
    override suspend fun invoke(): GetPokemonResponse? {
        repository.getPokemon()
        return null
    }
}