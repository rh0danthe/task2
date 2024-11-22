package com.example.task2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.task2.compose.Task2App
import com.example.task2.ui.theme.MyApplicationTheme
import com.example.task2.viewmodels.ElementViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            MyApplicationTheme{
                val viewModel: ElementViewModel = viewModel()
                Task2App(viewModel = viewModel)
            }
        }

    }
}
