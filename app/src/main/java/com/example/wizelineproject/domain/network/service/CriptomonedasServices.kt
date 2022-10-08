package com.example.wizelineproject.domain.network.service

import com.example.wizelineproject.domain.network.model.BookModel
import com.example.wizelineproject.domain.network.model.OrderBook
import com.example.wizelineproject.domain.network.model.Ticker
import com.example.wizelineproject.domain.network.response.GenericArrayResponse
import com.example.wizelineproject.domain.network.response.GenericObjectResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CriptomonedasServices {

    @GET("available_books")
    suspend fun getBooks(): GenericArrayResponse<BookModel>?

    @GET("ticker")
    suspend fun getTickers(@Query("book") book: String): GenericObjectResponse<Ticker>?

    @GET("order_book")
    suspend fun getBookOrders(@Query("book") book: String): GenericObjectResponse<OrderBook>?

}