package se.magictechnology.pia13android17feb

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute


@Composable
fun TodoNav(todoviewmodel : TodoViewModel = viewModel()) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "todolist") {

        composable("todolist") {
            TodoList(todoviewmodel = todoviewmodel,goDetail = { todoitem ->
                if(todoitem == null) {
                    navController.navigate(route = "tododetailnew")
                } else {
                    navController.navigate(route = todoitem)
                }
            })
        }

        composable<Todoitem> { backStackEntry ->
            val todoitem : Todoitem = backStackEntry.toRoute()
            TodoDetail(todoviewmodel = todoviewmodel, currenttodo = todoitem)
        }

        composable("tododetailnew") {
            TodoDetail(todoviewmodel = todoviewmodel, currenttodo = null)
        }

    }
}