package com.example.edutech_academy.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.res.painterResource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.Alignment
import com.example.edutech_academy.data.courseList

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun CourseDetailScreen(
    navController: NavController,
    courseId: Int
) {

    val course = courseList.find { it.id == courseId }

    // ⚠️ Validación básica
    if (course == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Curso no encontrado")
        }
        return
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(course.title) },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp)
        ) {

            // 🖼️ IMAGEN GRANDE
            Image(
                painter = painterResource(id = course.image),
                contentDescription = course.title,
                modifier = Modifier.fillMaxWidth().height(200.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // 📄 INFO
            Text(
                text = course.title,
                style = MaterialTheme.typography.headlineSmall
            )

            Text("Instructor: ${course.instructor}")
            Text("Nivel: ${course.level}")
            Text("Duración: ${course.duration}")

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = course.description,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(24.dp))

            // 🔘 BOTÓN INSCRIBIRSE
            Button(
                onClick = {
                    // Simulación
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Inscribirse")
            }
        }
    }
}