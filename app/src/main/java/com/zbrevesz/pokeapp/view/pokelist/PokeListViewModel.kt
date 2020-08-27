package com.zbrevesz.pokeapp.view.pokelist

import com.google.gson.GsonBuilder
import com.zbrevesz.pokeapp.model.PokemonList
import com.zbrevesz.pokeapp.remote.RemoteServiceInterface
import com.zbrevesz.pokeapp.view.pokedetail.PokeDetailViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokeListViewModel {
    companion object {
        val webservice by lazy {
            Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build().create(RemoteServiceInterface::class.java)
        }

        private const val LIMIT: Int = 20
        private const val OFFSET: Int = 20
    }

    init {
        GlobalScope.launch(Dispatchers.IO) {
            pokelist = webservice.getPokemonList(LIMIT, OFFSET)
        }
    }

    lateinit var pokelist: PokemonList
}