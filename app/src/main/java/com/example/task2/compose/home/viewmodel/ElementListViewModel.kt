package com.example.task2.compose.home.viewmodel

import com.example.task2.repo.ElementRepository
import com.example.task2.utils.BaseViewModel

fun listViewModel(dataRepository: ElementRepository) =
    BaseViewModel<ListState, ListOutputs, ListMessage>(
        initialState = ListState(),
        initialEvents = setOf(ListMessage.Load),
        processInputEvent = { event, state -> processInputEvent(dataRepository, event, state) }
    )

private suspend fun processInputEvent(
    dataRepository: ElementRepository,
    event: ListMessage,
    state: ListState
): Pair<ListState, Set<ListOutputs>> =
    when (event) {
        ListMessage.Load ->
            state.copy(
                isLoading = false,
                items = dataRepository.getAll()
            ) to emptySet()

        is ListMessage.OnOpenDetails ->
            state to setOfNotNull(
                dataRepository.getById(event.id.toString())
                    ?.let { ListOutputs.OpenDetails(it) }
            )
    }