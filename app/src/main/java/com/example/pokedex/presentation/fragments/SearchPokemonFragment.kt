package com.example.pokedex.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pokedex.databinding.FragmentSearchPokemonBinding
import com.example.pokedex.presentation.viewmodels.SearchPokemonViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchPokemonFragment : Fragment() {
    lateinit var binding : FragmentSearchPokemonBinding
    private val viewModel by viewModels<SearchPokemonViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.pokemonList.observe(this, Observer {
            if (it != null)
            {
                print(it)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchPokemonBinding.inflate(layoutInflater)
        return  binding.root
    }



    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchPokemonFragment().apply {

            }
    }
}