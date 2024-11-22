package com.example.task2.compose.home.viewmodel

import com.example.task2.data.Element

data class ListState(
    val isLoading: Boolean = true,
    val items: List<Element> = emptyList()
)

sealed interface ListMessage {
    data class OnOpenDetails(val id: String) : ListMessage
    data object Load : ListMessage
}

sealed interface ListOutputs {
    data class OpenDetails(val item: Element) : ListOutputs
}