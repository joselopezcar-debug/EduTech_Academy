package com.example.edutech_academy.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.edutech_academy.screens.*

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {

        // 🔐 LOGIN
        composable("login") {
            LoginScreen(navController)
        }

        // 🏠 HOME (recibe usuario)
        composable(
            route = "home/{user}",
            arguments = listOf(
                navArgument("user") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val user = backStackEntry.arguments?.getString("user") ?: "Usuario"
            HomeScreen(navController, user)
        }

        // 📚 LISTA DE CURSOS
        composable("courses") {
            CoursesScreen(navController)
        }

        // 📄 DETALLE DEL CURSO (recibe ID)
        composable(
            route = "courseDetail/{courseId}",
            arguments = listOf(
                navArgument("courseId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val courseId = backStackEntry.arguments?.getInt("courseId") ?: 0
            CourseDetailScreen(navController, courseId)
        }

        // 👤 PERFIL / MIS CURSOS
        composable("profile") {
            ProfileScreen(navController)
        }
    }
}