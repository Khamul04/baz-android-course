package com.example.wizelineproject.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wizelineproject.domain.network.model.BookModel
import com.example.wizelineproject.domain.repository.BooksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinsListViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var repository: BooksRepository

    private var _monedas = MutableLiveData<List<BookModel>>()
    val monedas = _monedas

    fun getBooks() {
        viewModelScope.launch {
            repository.getBooksFromNetwork { success, data ->
                if (success) {
                    _monedas.postValue(data)
                    CoroutineScope(Dispatchers.IO).launch {
                        repository.insertBooksToDatabase(data)
                    }
                } else
                    Log.e("log", "FALLO getBooks ViewModel")
            }
        }
    }
}
