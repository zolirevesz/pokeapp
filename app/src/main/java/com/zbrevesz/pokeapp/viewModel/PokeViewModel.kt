package com.zbrevesz.pokeapp.viewModel

import androidx.lifecycle.ViewModel
import com.zbrevesz.pokeapp.model.Pokemon
import com.zbrevesz.pokeapp.model.PokemonList
import com.zbrevesz.pokeapp.remote.RemoteServiceInterface
import org.koin.java.KoinJavaComponent.inject


class PokeViewModel(val webservice: RemoteServiceInterface): ViewModel() {

    lateinit var selectedPokemon: Pokemon
    lateinit var pokeList: PokemonList



}