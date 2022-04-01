package com.example.pokedex.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.domain.model.entities.response.GetPokemonResponse
import com.example.pokedex.domain.usecase.GetPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailPokemonFragmentViewModel @Inject constructor(private val getPokemonUseCase : GetPokemonUseCase)
    : ViewModel() {

    private var _pokemonData = MutableLiveData<GetPokemonResponse>()
    val pokemonData : LiveData<GetPokemonResponse>
        get() = _pokemonData



     fun getPokemon(urlOfPokemon : String) {

        val queryOfPokemon =  urlOfPokemon.substringAfter("v2/")
        viewModelScope.launch(Dispatchers.IO){
            val pokemonDataResponse = getPokemonUseCase.invoke(queryOfPokemon)
            _pokemonData.postValue(pokemonDataResponse)

        }
    }
}