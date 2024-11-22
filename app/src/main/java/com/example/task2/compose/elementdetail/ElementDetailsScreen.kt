package com.example.task2.compose.elementdetail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.task2.compose.elementdetail.viewmodel.DetailsMessage
import com.example.task2.compose.elementdetail.viewmodel.DetailsOutputs
import com.example.task2.compose.elementdetail.viewmodel.DetailsState
import com.example.task2.compose.elementdetail.viewmodel.detailsViewModel
import com.example.task2.data.Element
import com.example.task2.utils.SubscribeEvents
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun ElementDetailsScreen(
    item: Element,
    navigator: DestinationsNavigator,
) {
    val viewModel = viewModel { detailsViewModel(item) }
    val state by viewModel.screenState.collectAsStateWithLifecycle()
    viewModel.SubscribeEvents {
        when (it) {
            DetailsOutputs.Close -> navigator.navigateUp()
        }
    }

    DetailUI(state, onBackClick = { viewModel.dispatch(DetailsMessage.Close) })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailUI(
    state: DetailsState,
    onBackClick: () -> Unit
) {
    val element = state.item

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Element Details") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Black
                )
            )
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(contentPadding),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = element.imageUrl,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )

            Text(
                text = "${element.name}\n${element.subtitle}",
                color = Color.White,
                textAlign = TextAlign.Left,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}

