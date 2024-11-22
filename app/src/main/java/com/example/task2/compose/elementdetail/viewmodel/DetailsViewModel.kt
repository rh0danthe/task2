package com.example.task2.compose.elementdetail.viewmodel

import com.example.task2.data.Element
import com.example.task2.utils.BaseViewModel

fun detailsViewModel(initial: Element) =
    BaseViewModel(
        initialState = DetailsState(initial),
        processInputEvent = ::processInputEvent
    )

fun processInputEvent(
    event: DetailsMessage,
    state: DetailsState
): Pair<DetailsState, Set<DetailsOutputs>> =
    when (event) {
        DetailsMessage.Close -> state to setOf(DetailsOutputs.Close)
    }