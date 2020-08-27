package com.zbrevesz.pokeapp.model


data class PokemonList (
    var count : Int,
    var next : String,
    var previous : String,
    var results : List<PokemonLink>
)

data class PokemonLink (
    var name: String,
    var url : String
)