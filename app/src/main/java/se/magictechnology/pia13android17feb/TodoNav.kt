package se.magictechnology.pia13android17feb

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute


@Composable
fun TodoNav() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "todolist") {

        composable("todolist") {
            TodoList(goDetail = { todoitem ->
                navController.navigate(route = todoitem)
            })
        }

        composable<Todoitem> { backStackEntry ->
            val todoitem : Todoitem = backStackEntry.toRoute()
            TodoDetail(currenttodo = todoitem)
        }

    }
}