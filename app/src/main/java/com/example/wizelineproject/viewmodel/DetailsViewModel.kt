package com.example.wizelineproject.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wizelineproject.domain.network.model.Ticker
import com.example.wizelineproject.domain.repository.BooksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var repository: BooksRepository

    private val _ticker = MutableLiveData<Ticker>()
    var ticker = _ticker

    fun getBooks(book: String) {
        repository.getTickerWithRxJava(book) { success, data ->
            if (success) {
                _ticker.postValue(data)
            } else
                Log.e("log", "FALLO getDetail ViewModel")
        }
    }
}
