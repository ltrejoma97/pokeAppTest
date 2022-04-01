package com.example.pokedex.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.pokedex.R
import com.example.pokedex.databinding.ActivityMainBinding
import com.example.pokedex.presentation.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    lateinit var navController : NavController
    lateinit var binding : ActivityMainBinding
    lateinit var viewModel : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavigation()
        initViewModel()

    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private fun initNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
         navController = navHostFragment.navController
        navHostFragment.navController
        initNavigationMenu()
    }

    private fun initNavigationMenu() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.home_page -> {
                    navController.navigateUp()
                    true
                }
                R.id.pokeball_page -> {
                    navController.navigateUp()
                    navController.navigate(R.id.action_homeFragment_to_searchPokemonFragment)
                    true
                }
                R.id.setting_page ->{
                    navController.navigateUp()
                    navController.navigate(R.id.action_homeFragment_to_settingsFragment)
                    true
                }
                else -> false
            }
        }
    }

    override fun onBackPressed() {
        if (navController.currentDestination?.label == "fragment_detail_pokemon")
        {
            navController.navigateUp()
        }
    }
}