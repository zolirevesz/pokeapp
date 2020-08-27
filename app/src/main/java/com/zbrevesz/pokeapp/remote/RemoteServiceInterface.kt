package com.zbrevesz.pokeapp.remote

import com.zbrevesz.pokeapp.model.Pokemon
import com.zbrevesz.pokeapp.model.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RemoteServiceInterface {
    companion object {
        private val OFFSET: Int = 20
    }

    @GET("pokemon")
    suspend fun getPokemonList(@Query("limit") limit: Int, @Query("offset") offset: Int): PokemonList

    @GET("pokemon/{pokeid}")
    suspend fun getPokemon(@Path("pokeid") pokeId: Int): Pokemon
}