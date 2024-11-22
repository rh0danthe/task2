package com.example.task2.compose.elementdetail.viewmodel

import com.example.task2.data.Element

data class DetailsState(val item: Element)

sealed interface DetailsMessage {
    data object Close : DetailsMessage
}

sealed interface DetailsOutputs {
    data object Close : DetailsOutputs}