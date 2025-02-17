package se.magictechnology.pia13android17feb

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TodoViewModel : ViewModel() {

    private val _todoitems = MutableStateFlow(mutableStateListOf<Todoitem>())
    val todoitems: StateFlow<List<Todoitem>> = _todoitems.asStateFlow()

    fun addTodo(title : String, done : Boolean) {
        var newtodo = Todoitem(title, done)
       _todoitems.value.add(newtodo)
    }

    fun deleteTodo(todo : Todoitem) {
    }

    fun markDone(todo : Todoitem) {
    }

    fun editTodo(todo : Todoitem) {
    }

}