package com.example.daggerhiltcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.daggerhiltcourse.ui.theme.DaggerHiltCourseTheme
import dagger.hilt.android.AndroidEntryPoint

//HILT = Module yang menentukan masuk ke component mana dengan di install(installin)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DaggerHiltCourseTheme {
                // A surface container using the 'background' color from the theme
           val viewModel = hiltViewModel<MyViewModel>()
            }
        }
    }
}