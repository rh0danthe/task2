package com.example.task2.viewmodels

import androidx.lifecycle.ViewModel
import com.example.task2.data.Element
import com.example.task2.repo.ElementRepository

class ElementViewModel : ViewModel() {

    private val repository = ElementRepository()

    fun getAll(): List<Element> {
        return repository.getAll()
    }

    fun getById(id: String): Element? {
        return repository.getById(id)
    }
}