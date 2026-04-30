package com.example.edutech_academy.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.res.painterResource
import kotlin.random.Random

import com.example.edutech_academy.data.courseList
import com.example.edutech_academy.model.Course

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {

    val userName = "Usuario Demo"
    val enrolledCourses = courseList.take(3)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mi Perfil") },
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

            Text(
                text = userName,
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Cursos inscritos",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(enrolledCourses) { course ->
                    EnrolledCourseItem(course)
                }
            }
        }
    }
}

@Composable
fun EnrolledCourseItem(course: Course) {

    // 🔥 FIX: remember + Random correctamente
    val progress = remember { Random.nextInt(30, 90) / 100f }

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(12.dp)) {

            Row {

                Image(
                    painter = painterResource(id = course.image),
                    contentDescription = course.title,
                    modifier = Modifier.size(70.dp)
                )

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(course.title, style = MaterialTheme.typography.titleMedium)
                    Text("Progreso: ${(progress * 100).toInt()}%")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            LinearProgressIndicator(
                progress = progress,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}