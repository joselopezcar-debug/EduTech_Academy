package com.example.edutech_academy.model

data class Course(
    val id: Int,
    val title: String,
    val instructor: String,
    val level: String,
    val category: String,
    val duration: String,
    val description: String,
    val image: Int
)