package com.zbrevesz.pokeapp.model

data class Pokemon (
    var sprites: List<Sprites>,
    var weight: Int,
    var height: Int,
    var abilities: List <Abilities>
)

data class Sprites (
    var front_default: String
)

data class Abilities (
    var ability: List<AbilityInfo>,
    var is_hidden: Boolean
)

data class AbilityInfo (
    var name: String
)