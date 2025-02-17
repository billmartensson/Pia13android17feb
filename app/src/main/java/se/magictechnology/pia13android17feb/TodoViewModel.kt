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
        _todoitems.value.remove(todo)
    }

    fun switchDone(todo : Todoitem) {

        val todoindex = _todoitems.value.indexOf(todo)

        val newtodo = Todoitem(todo.todotitle, !todo.tododone)

        _todoitems.value[todoindex] = newtodo

    }

    fun editTodo(todo : Todoitem, newtitle : String) {

        val todoindex = _todoitems.value.indexOf(todo)

        val newtodo = Todoitem(newtitle, todo.tododone)

        _todoitems.value[todoindex] = newtodo

    }

}