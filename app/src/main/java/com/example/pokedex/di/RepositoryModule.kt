package com.example.pokedex.di

import com.example.pokedex.data.repositories.GetPokemonListRepository
import com.example.pokedex.data.repositories.GetPokemonListRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


//Donde esta atachado este singleton Component
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideGetPokemonListRepository(): GetPokemonListRepository{
        return GetPokemonListRepositoryImp()
    }
}