package com.zbrevesz.pokeapp.view.pokedetail

import com.google.gson.GsonBuilder
import com.zbrevesz.pokeapp.model.Pokemon
import com.zbrevesz.pokeapp.remote.RemoteServiceInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokeDetailViewModel(private val pokeId: Int) {
    companion object {
        val webservice by lazy {
            Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build().create(RemoteServiceInterface::class.java)
        }
    }

    init {
        GlobalScope.launch(Dispatchers.IO) {
            pokemon = webservice.getPokemon(pokeId)
        }
    }

    lateinit var pokemon: Pokemon

}