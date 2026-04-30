package com.example.edutech_academy.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.res.painterResource
import com.example.edutech_academy.data.courseList
import com.example.edutech_academy.model.Course

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun CoursesScreen(navController: NavController) {

    var selectedCategory by remember { mutableStateOf("Todos") }

    val filteredCourses = when (selectedCategory) {
        "Programación" -> courseList.filter { it.category == "Programación" }
        "Diseño" -> courseList.filter { it.category == "Diseño" }
        "Negocios" -> courseList.filter { it.category == "Negocios" }
        else -> courseList
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cursos") }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier.fillMaxSize().padding(padding).padding(16.dp)
        ) {

            // 🔘 FILTROS
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                FilterButton("Todos", selectedCategory) { selectedCategory = "Todos" }
                FilterButton("Programación", selectedCategory) { selectedCategory = "Programación" }
                FilterButton("Diseño", selectedCategory) { selectedCategory = "Diseño" }
                FilterButton("Negocios", selectedCategory) { selectedCategory = "Negocios" }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 📚 LISTA
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(filteredCourses) { course ->
                    CourseItem(course) {
                        navController.navigate("courseDetail/${course.id}")
                    }
                }
            }
        }
    }
}

@Composable
fun FilterButton(
    text: String,
    selected: String,
    onClick: () -> Unit
) {
    val isSelected = text == selected

    Button(
        onClick = onClick,
        colors = if (isSelected)
            ButtonDefaults.buttonColors()
        else
            ButtonDefaults.outlinedButtonColors()
    ) {
        Text(text)
    }
}

@Composable
fun CourseItem(
    course: Course,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable { onClick() }
    ) {
        Row(modifier = Modifier.padding(12.dp)) {

            Image(
                painter = painterResource(id = course.image),
                contentDescription = course.title,
                modifier = Modifier.size(80.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(course.title, style = MaterialTheme.typography.titleMedium)
                Text("Instructor: ${course.instructor}")
                Text("Nivel: ${course.level}")
            }
        }
    }
}