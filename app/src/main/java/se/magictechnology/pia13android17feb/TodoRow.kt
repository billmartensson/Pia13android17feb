package se.magictechnology.pia13android17feb

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TodoRow(todoitem : Todoitem, clickrow : () -> Unit, clickdone : () -> Unit) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
        .clickable { clickrow() }
    ) {

        Text(todoitem.todotitle, modifier = Modifier.weight(1F))

        if(todoitem.tododone) {
            Text("DONE", modifier = Modifier.clickable { clickdone() })
        } else {
            Text("NOT DONE", modifier = Modifier.clickable { clickdone() })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TodoRowPreview() {
    TodoRow(todoitem = Todoitem("This is a todo", false), clickdone = {}, clickrow = {})
}