package com.example.pokedex.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.domain.model.entities.Pokemon
import java.util.*

class PokemonListAdapter(private val pokemonDataSet: ArrayList<Pokemon>, val pokemonClickListenerContract : PokemonFragmentContract ) :
    RecyclerView.Adapter<PokemonListAdapter.PokemonViewHolder>() {
    val initialPokemonDataListForFilter = ArrayList<Pokemon>().apply {
        pokemonDataSet.let { addAll(it) }
    }

    interface PokemonFragmentContract{
        fun notifyPokemonSelected(urlOfPokemon : String)
    }


    class PokemonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
         val pokemonNameTextView: TextView = view.findViewById(R.id.pokemonName)

        fun bind( pokemon : Pokemon){
            pokemonNameTextView.text = pokemon.name
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): PokemonViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.pokemon_row_item, viewGroup, false)

        return PokemonViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(pokemonViewHolder: PokemonViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val pokemonFromTheList = pokemonDataSet[position]
        pokemonViewHolder.bind(pokemonFromTheList)
        //Copy of data for perform search
        //Listener for click on pokemon
        pokemonViewHolder.pokemonNameTextView.setOnClickListener {
            pokemonClickListenerContract.notifyPokemonSelected(pokemonFromTheList.url)
        }

    }
    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = pokemonDataSet.size

    fun getFilter(): Filter {
        return pokemonFilter
    }

    private val pokemonFilter = object : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val filteredList: ArrayList<Pokemon> = ArrayList()
            if (constraint == null || constraint.isEmpty()) {
                initialPokemonDataListForFilter.let { filteredList.addAll(it) }
            } else {
                val query = constraint.toString().trim().toLowerCase()
                initialPokemonDataListForFilter.forEach {
                    if (it.name.lowercase(Locale.ROOT).contains(query)) {
                        filteredList.add(it)
                    }
                }
            }
            val results = FilterResults()
            results.values = filteredList
            return results
        }

        override fun publishResults(p0: CharSequence?, resultOfFilter: FilterResults?) {
            if (resultOfFilter?.values is ArrayList<*>) {
                pokemonDataSet.clear()
                pokemonDataSet.addAll(resultOfFilter.values as ArrayList<Pokemon>)
                notifyDataSetChanged()
            }
        }
        }
    }