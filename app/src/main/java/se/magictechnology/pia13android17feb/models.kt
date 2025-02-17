package se.magictechnology.pia13android17feb

import kotlinx.serialization.Serializable


@Serializable
data class Todoitem(var todotitle : String, var tododone : Boolean)