package com.example.pokedex.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.databinding.FragmentSearchPokemonBinding
import com.example.pokedex.domain.model.entities.GetPokemonListResponse
import com.example.pokedex.presentation.adapter.PokemonListAdapter
import com.example.pokedex.presentation.viewmodels.SearchPokemonViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchPokemonFragment : Fragment(), PokemonListAdapter.PokemonFragmentContract {
    lateinit var binding : FragmentSearchPokemonBinding
    private val viewModel by viewModels<SearchPokemonViewModel>()
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initObservers()
    }

    private fun handlePokemonDataCatched() {
        if (viewModel.pokemonList.value !=null )
        {
            createPokemonAdapterAndUi(viewModel.pokemonList.value!!)
        }
    }

    override fun onResume() {
        super.onResume()
        handlePokemonDataCatched()

    }

    private fun initObservers() {
        viewModel.pokemonList.observe(this, Observer {pokemonDataList : GetPokemonListResponse ->
            hideProgressBar()
            createPokemonAdapterAndUi(pokemonDataList)
        })
        viewModel.isProgressBarDisplayed.observe(this, Observer { isProgressBarDisplayed : Boolean ->
            if (isProgressBarDisplayed)
            {
                binding.determinateBar.visibility = View.VISIBLE
            }else{
                binding.determinateBar.visibility = View.GONE
            }
        })
    }

    private fun createPokemonAdapterAndUi(it: GetPokemonListResponse) {
        val pokemonAdapter = PokemonListAdapter(it.results, this)
        initPokemonRecyclerView(pokemonAdapter)
        initPokemonSearchBar(pokemonAdapter)
    }

    private fun hideProgressBar() {
        binding.progressBarContainer.visibility=View.GONE
        binding.searchContainer.visibility = View.VISIBLE
    }

    private fun initPokemonRecyclerView(pokemonAdapter: PokemonListAdapter) {
        val pokemonRecyclerView: RecyclerView = binding.pokemonRecyclerViewLayout
        linearLayoutManager = LinearLayoutManager(context)
        pokemonRecyclerView.layoutManager = linearLayoutManager
        pokemonRecyclerView.adapter = pokemonAdapter
    }

    private fun initPokemonSearchBar(pokemonAdapter: PokemonListAdapter) {
        binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                pokemonAdapter.getFilter().filter(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                pokemonAdapter.getFilter().filter(newText);
                return true
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

    override fun notifyPokemonSelected(urlOfPokemon: String) {
        // Use the Kotlin extension in the fragment-ktx artifact
        this.setFragmentResult("pokemonUrl", bundleOf("bundleKey" to urlOfPokemon))
        this.findNavController().navigate(R.id.action_searchPokemonFragment_to_detailPokemonFragment)
    }


}

//The recycler view have in the Fragment or activity
//An Adapter that hold all the logic for display
//Linear layout manager for know how display the names.