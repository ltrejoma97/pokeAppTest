package com.example.pokedex.di

import com.example.pokedex.data.repositories.GetPokemonListRepository
import com.example.pokedex.data.repositories.GetPokemonRepository
import com.example.pokedex.domain.usecase.GetPokemonListUseCase
import com.example.pokedex.domain.usecase.GetPokemonListUseCaseImp
import com.example.pokedex.domain.usecase.GetPokemonUseCase
import com.example.pokedex.domain.usecase.GetPokemonUseCaseImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetPokemonListUseCase(repository: GetPokemonListRepository) : GetPokemonListUseCase{
        return GetPokemonListUseCaseImp(repository)
    }

    @Provides
    fun providesGetPokemonUseCase(repository : GetPokemonRepository) : GetPokemonUseCase{
        return GetPokemonUseCaseImp(repository)
    }


}