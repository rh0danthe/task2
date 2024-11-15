package com.example.task2.compose.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.task2.data.Element
import com.example.task2.viewmodels.ElementViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: ElementViewModel,
    onElemClick: (Element) -> Unit
) {
    val elements = viewModel.getAll()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Elements List") },
            )
        }
    ) { contentPadding ->
        LazyColumn(
            modifier = Modifier.padding(contentPadding)
        ) {
            items(elements,  key = { it.id }) { element ->
                ElementListItem(element = element){
                    onElemClick(element)
                }
            }
        }
    }
}

