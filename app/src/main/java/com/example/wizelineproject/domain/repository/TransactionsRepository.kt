package com.example.wizelineproject.domain.repository

import android.util.Log
import com.example.wizelineproject.domain.database.dao.BooksDao
import com.example.wizelineproject.domain.database.entities.BooksEntity
import com.example.wizelineproject.domain.network.model.OrderBook
import com.example.wizelineproject.domain.network.service.CriptomonedasServices
import retrofit2.Retrofit

class TransactionsRepository: GenericRepository<CriptomonedasServices>() {

    override lateinit var api: CriptomonedasServices
    lateinit var booksDao: BooksDao

    fun configRepository(retrofit: Retrofit, criptomonedasServices: CriptomonedasServices, daoBooks: BooksDao){
        client = retrofit
        api = criptomonedasServices
        booksDao = daoBooks
    }

    suspend fun getTransactions(book:String, callback: (success: Boolean, data: OrderBook?) -> Unit){
        getResponseWithObject({
            api.getBookOrders(book)
        }){ success: Boolean, data: OrderBook? ->
            callback(success, data)
        }
    }

    suspend fun getBooksFromDatabase():List<BooksEntity>{
        return booksDao.getAlphabetizedBooks()
    }

}