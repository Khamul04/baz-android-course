package com.example.wizelineproject.domain.repository

import android.util.Log
import com.example.wizelineproject.domain.database.dao.BooksDao
import com.example.wizelineproject.domain.database.entities.BooksEntity
import com.example.wizelineproject.domain.network.model.BookModel
import com.example.wizelineproject.domain.network.model.OrderBook
import com.example.wizelineproject.domain.network.model.Ticker
import com.example.wizelineproject.domain.network.model.toBookEntity
import com.example.wizelineproject.domain.network.service.CriptomonedasServices
import retrofit2.Retrofit

class BooksRepository: GenericRepository<CriptomonedasServices>(){

    override lateinit var api: CriptomonedasServices
    lateinit var booksDao: BooksDao

    fun configRepository(retrofit: Retrofit, criptomonedasServices: CriptomonedasServices, daoBooks: BooksDao){
        client = retrofit
        api = criptomonedasServices
        booksDao = daoBooks
    }

    suspend fun getBooksFromNetwork(callback: (success:Boolean, data: List<BookModel>)->Unit){
        getResponseWithArray({
            api.getBooks()
        }){ success: Boolean, data: List<BookModel> ->
            callback(success, data)
        }
    }

    suspend fun getTicker(book:String, callback: (success:Boolean, data: Ticker?)->Unit){
        getResponseWithObject({
            api.getTickers(book)
        }){ success: Boolean, data: Ticker? ->
            callback(success, data)
        }
    }

    /*suspend fun getTransactions(book:String, callback: (success: Boolean, data: OrderBook?) -> Unit){
        getResponseWithObject({
            api.getBookOrders(book)
        }){ success: Boolean, data: OrderBook? ->
            callback(success, data)
        }
    }*/

    /*suspend fun getOrderBooks(book:String, callback: (success:Boolean, data: OrderBook?)->Unit){
        getResponseWithObject({
            api.getBookOrders(book)
        }){ success: Boolean, data: OrderBook? ->
            callback(success, data)
        }
    }*/

    suspend fun insertBooksToDatabase(booksModel: List<BookModel>){
        var booksEntity = mutableListOf<BooksEntity>()
        booksModel.forEach {
            booksEntity.add(it.toBookEntity())
        }
        booksDao.insertAll(booksEntity)
    }
}