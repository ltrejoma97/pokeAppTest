package com.example.pokedex.di

import com.example.pokedex.data.EndPoints
import com.example.pokedex.data.repositories.GetPokemonListRepository
import com.example.pokedex.data.repositories.GetPokemonListRepositoryImp
import com.example.pokedex.data.repositories.GetPokemonRepository
import com.example.pokedex.data.repositories.GetPokemonRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


//Donde esta atachado este singleton Component
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideGetPokemonListRepository(endPoints: EndPoints): GetPokemonListRepository{
        return GetPokemonListRepositoryImp(endPoints)
    }

    @Provides
    fun provideGetPokemonRepository(endPoints: EndPoints) : GetPokemonRepository{
        return GetPokemonRepositoryImp(endPoints)
    }

}