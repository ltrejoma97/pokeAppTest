package com.example.pokedex.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.domain.usecase.GetPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getPokemonListUseCase: GetPokemonListUseCase)
    :ViewModel() {
    init {
        getPokemonList()
    }

    private fun getPokemonList() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = getPokemonListUseCase.invoke()
            if (response != null) {
                if (response.count.isNotEmpty()) {
                    print(response)
                }
            }
        }
    }
}