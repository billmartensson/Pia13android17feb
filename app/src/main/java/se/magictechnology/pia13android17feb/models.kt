package se.magictechnology.pia13android17feb

import kotlinx.serialization.Serializable


@Serializable
data class Todoitem(val todotitle : String, val tododone : Boolean)