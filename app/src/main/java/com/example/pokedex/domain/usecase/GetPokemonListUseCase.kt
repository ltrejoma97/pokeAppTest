package com.example.pokedex.domain.usecase

import com.example.pokedex.domain.model.entities.GetPokemonListResponse
import javax.inject.Inject

interface GetPokemonListUseCase {
    suspend fun invoke() : GetPokemonListResponse?
}
class GetPokemonListUseCaseImp @Inject constructor() : GetPokemonListUseCase{
    override suspend fun invoke(): GetPokemonListResponse? {

        println("hilt works well ")
        return null
    }
}