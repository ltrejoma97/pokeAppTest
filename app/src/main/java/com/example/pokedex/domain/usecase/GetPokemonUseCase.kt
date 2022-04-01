package com.example.pokedex.domain.usecase

import com.example.pokedex.domain.model.entities.response.GetPokemonResponse

interface GetPokemonUseCase {
    suspend fun invoke () : GetPokemonResponse?
}

class GetPokemonUseCaseImp () : GetPokemonUseCase {
    override suspend fun invoke(): GetPokemonResponse? {
         print("hola me creaste jeje")
        return null
    }
}