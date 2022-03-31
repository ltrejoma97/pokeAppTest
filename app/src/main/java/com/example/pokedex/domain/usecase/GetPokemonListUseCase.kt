package com.example.pokedex.domain.usecase

import com.example.pokedex.data.repositories.GetPokemonListRepository
import com.example.pokedex.domain.model.entities.GetPokemonListResponse
import javax.inject.Inject

interface GetPokemonListUseCase {
    suspend fun invoke() : GetPokemonListResponse?
}
class GetPokemonListUseCaseImp @Inject constructor(val repository: GetPokemonListRepository) : GetPokemonListUseCase{
    override suspend fun invoke(): GetPokemonListResponse? {
        repository.getPokemonList()
        println("hilt works well ")
        return null
    }
}