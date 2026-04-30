package com.example.edutech_academy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.edutech_academy.navigation.AppNavigation
import com.example.edutech_academy.ui.theme.EduTech_AcademyTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            EduTech_AcademyTheme {
                AppNavigation()
            }
        }
    }
}