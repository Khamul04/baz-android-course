package com.example.wizelineproject.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wizelineproject.domain.network.model.Ticker
import com.example.wizelineproject.domain.repository.BooksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var repository: BooksRepository

    private val _ticker = MutableLiveData<Ticker>()
    var ticker = _ticker

    fun getBooks(book: String) {
        viewModelScope.launch {
            repository.getTicker(book) { success, data ->
                if (success) {
                    _ticker.postValue(data)
                } else
                    Log.e("log", "FALLO getDetail ViewModel")
            }
        }
    }
}