package com.example.task2.compose.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.task2.compose.destinations.ElementDetailsScreenDestination
import com.example.task2.compose.home.viewmodel.ListMessage
import com.example.task2.compose.home.viewmodel.ListOutputs
import com.example.task2.compose.home.viewmodel.ListState
import com.example.task2.compose.home.viewmodel.listViewModel
import com.example.task2.repo.ElementRepository
import com.example.task2.utils.SubscribeEvents
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator
) {
    val viewModel = viewModel { listViewModel(ElementRepository()) }
    val state by viewModel.screenState.collectAsStateWithLifecycle()
    viewModel.SubscribeEvents {
        when (it) {
            is ListOutputs.OpenDetails ->
                navigator.navigate(ElementDetailsScreenDestination(it.item))
        }
    }

    ListUI(
        state = state,
        onElemClick = { elementId -> viewModel.dispatch(ListMessage.OnOpenDetails(elementId)) }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ListUI(
    state: ListState,
    onElemClick: (String) -> Unit
) {

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
            items(state.items,  key = { it.id }) { element ->
                ElementListItem(element = element){
                    onElemClick(element.id)
                }
            }
        }
    }
}

