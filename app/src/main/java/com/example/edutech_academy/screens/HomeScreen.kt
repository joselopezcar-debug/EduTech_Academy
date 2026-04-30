package com.example.edutech_academy.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun HomeScreen(
    navController: NavController,
    user: String
) {

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("EduTech Academy") })
        }
    ) { padding ->

        Column(
            modifier = Modifier.fillMaxSize().padding(padding).padding(24.dp),
            verticalArrangement = Arrangement.Top
        ) {

            // 👋 SALUDO
            Text(
                text = "Hola, $user 👋",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "¿Qué quieres hacer hoy?",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(24.dp))

            // 📚 BOTÓN CURSOS
            Button(
                onClick = { navController.navigate("courses") },
                modifier = Modifier.fillMaxWidth().height(60.dp)
            ) {
                Text("Explorar Cursos")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 🎓 BOTÓN MIS CURSOS
            Button(
                onClick = { navController.navigate("profile") },
                modifier = Modifier.fillMaxWidth().height(60.dp)
            ) {
                Text("Mis Cursos")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 👤 BOTÓN PERFIL
            OutlinedButton(
                onClick = { navController.navigate("profile") },
                modifier = Modifier.fillMaxWidth().height(60.dp)
            ) {
                Text("Mi Perfil")
            }
        }
    }
}