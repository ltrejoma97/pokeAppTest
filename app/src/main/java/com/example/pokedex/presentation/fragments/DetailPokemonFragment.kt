package com.example.pokedex.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.text.capitalize
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.pokedex.R
import com.example.pokedex.databinding.FragmentDetailPokemonBinding
import com.example.pokedex.domain.model.entities.response.GetPokemonResponse
import com.example.pokedex.presentation.viewmodels.DetailPokemonFragmentViewModel
import com.example.pokedex.presentation.viewmodels.SearchPokemonViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailPokemonFragment : Fragment() {
    lateinit var binding : FragmentDetailPokemonBinding
    private val viewModel by viewModels<DetailPokemonFragmentViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handleBundleFromSearchPokemonFragment()
        viewModel.pokemonData.observe(this, Observer {
            renderTheUi(it)
        })

    }

    private fun renderTheUi(pokemonData: GetPokemonResponse?) {
        if (pokemonData != null) {
            binding.abilityOfPokemon.text =   pokemonData.abilities[0].ability.name
            binding.baseExperience.text = binding.baseExperience.text.toString() +   pokemonData.base_experience.toString()
            binding.heightOfPokemon.text = binding.baseExperience.text .toString() + pokemonData.height.toString()
            binding.weightOfPokemon.text= binding.weightOfPokemon.text.toString() + pokemonData.weight.toString()
            binding.nameOfPokemon.text = binding.nameOfPokemon.text.toString()  + pokemonData.name.capitalize()
            Picasso.get().load(pokemonData.sprites.front_default).into(binding.frontImageOfPokemon);
            binding.progressBarContainer.visibility = View.GONE

        }

    }

    private fun handleBundleFromSearchPokemonFragment() {
        this.setFragmentResultListener(requestKey = "pokemonUrl") { key, bundle ->
            val urlOfPokemon = bundle.getString("bundleKey")
            urlOfPokemon?.let { viewModel.getPokemon(it) }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentDetailPokemonBinding.inflate(layoutInflater)
        return binding.root
    }


}