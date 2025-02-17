package se.magictechnology.pia13android17feb

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TodoList(goDetail : (todoitem : Todoitem) -> Unit) {

    var todoitems = remember { mutableStateListOf<Todoitem>() }

    Column(modifier = Modifier.fillMaxSize()) {
        Text("LIST")

        Button(onClick = {
            var temptodo = Todoitem("Lets do something", false)
            goDetail(temptodo)
        }) {
            Text("GO DETAIL")
        }

        Button(onClick = {
            todoitems.add(Todoitem("XYZ", false))
        }) {
            Text("ADD")
        }

        LazyColumn(modifier = Modifier.fillMaxWidth().weight(1F)) {
            items(todoitems) { todoitem ->
                Row(modifier = Modifier.clickable {
                    goDetail(todoitem)
                }) {
                    Text(todoitem.todotitle)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TodoListPreview() {
    TodoList(goDetail = {})
}