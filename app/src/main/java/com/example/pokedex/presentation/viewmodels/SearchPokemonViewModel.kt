package com.example.pokedex.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.domain.model.entities.GetPokemonListResponse
import com.example.pokedex.domain.usecase.GetPokemonListUseCase
import com.example.pokedex.domain.usecase.GetPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


//Se diseñó la clase ViewModel a fin de almacenar y administra
//r datos relacionados con la IU de manera optimizada para los ciclos de vida.
//La clase ViewModel permite que se conserven los datos luego
//de cambios de configuración, como las rotaciones de pantallas.

@HiltViewModel
class SearchPokemonViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase) : ViewModel() {

    private var _pokemonList =  MutableLiveData<GetPokemonListResponse>()
    val pokemonList : LiveData<GetPokemonListResponse>
        get() =  _pokemonList

    private var _isProgressBarDisplayed = MutableLiveData <Boolean>()
    val  isProgressBarDisplayed : LiveData<Boolean>
        get() = _isProgressBarDisplayed

    init{
        getPokemonList()
    }


    private fun getPokemonList() {
        showProgressBar()
        viewModelScope.launch(Dispatchers.IO) {
            val getPokemonResponse = getPokemonListUseCase.invoke()
            if (getPokemonResponse.count.isNotEmpty()) {
                _pokemonList.postValue(getPokemonResponse)
                hideProgressBar()
            }
        }
    }

    private fun showProgressBar(){
        _isProgressBarDisplayed.value = true
    }
    private fun hideProgressBar(){
        _isProgressBarDisplayed.postValue(false)
    }
}