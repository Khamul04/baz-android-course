package com.example.wizelineproject.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wizelineproject.domain.network.model.TransactionModel
import com.example.wizelineproject.domain.repository.TransactionsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BidsViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var repository: TransactionsRepository

    private val _bids = MutableLiveData<List<TransactionModel>?>()
    var bids = _bids

    private val _names = MutableLiveData<List<String>?>()
    var names = _names

    fun getBids(book: String) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.getTransactions(book) { success, data ->
                if (success) {
                    _bids.postValue(data?.bids)
                } else
                    Log.e("log", "FAIL getBids ViewModel")
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