package com.example.wizelineproject.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wizelineproject.domain.network.model.TransactionModel
import com.example.wizelineproject.domain.repository.TransactionsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AsksViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var repository: TransactionsRepository

    private val _asks = MutableLiveData<List<TransactionModel>?>()
    var asks = _asks

    private val _names = MutableLiveData<List<String>?>()
    var names = _names

    fun getAsks(book: String) {
        viewModelScope.launch {
            repository.getTransactions(book) { success, data ->
                if (success) {
                    _asks.postValue(data?.asks)
                } else
                    Log.e("log", "FAIL getAsks ViewModel")
            }
        }
    }

    fun getBooksNames() {
        val namesLocal = mutableListOf<String>()
        viewModelScope.launch {
            val listNames = repository.getBooksFromDatabase()
            listNames.forEach {
                namesLocal.add(it.name)
            }
            _names.postValue(namesLocal)
        }
    }
}
