package com.example.pokedex.di

import com.example.pokedex.data.repositories.GetPokemonListRepository
import com.example.pokedex.domain.usecase.GetPokemonListUseCase
import com.example.pokedex.domain.usecase.GetPokemonListUseCaseImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetPokemonListUseCase() : GetPokemonListUseCase{
        return GetPokemonListUseCaseImp()
    }


}