package se.magictechnology.pia13android17feb

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TodoDetail(todoviewmodel : TodoViewModel,  currenttodo : Todoitem?) {

    var todotext by remember { mutableStateOf("") }

    LaunchedEffect(true) {
        if(currenttodo != null) {
            todotext = currenttodo.todotitle
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Text("DETAIL")
        TextField(value = todotext, onValueChange = {todotext = it})

        Button(onClick = {
            if(currenttodo == null) {
                todoviewmodel.addTodo(todotext, false)
            } else {
                todoviewmodel.editTodo(currenttodo, todotext)
            }

        }) {
            if(currenttodo == null) {
                Text("Add")
            } else {
                Text("Save")
            }
        }

        if(currenttodo != null) {
            Button(onClick = {
                todoviewmodel.deleteTodo(currenttodo)
            }) {
                Text("Delete")
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun TodoDetailPreview() {
    TodoDetail(todoviewmodel = viewModel(), currenttodo = Todoitem("Test", false))
}

@Preview(showBackground = true)
@Composable
fun TodoDetailPreviewNew() {
    TodoDetail(todoviewmodel = viewModel(), currenttodo = null)
}