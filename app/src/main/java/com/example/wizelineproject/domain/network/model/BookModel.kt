package com.example.wizelineproject.domain.network.model

import com.example.wizelineproject.domain.database.entities.BooksEntity
import com.google.gson.annotations.SerializedName

data class BookModel(
                @SerializedName("book")
                val book:String,
                @SerializedName("minimum_amount")
                val minimum_amount:String,
                @SerializedName("maximum_amount")
                val maximum_amount:String,
                @SerializedName("minimum_price")
                val minimum_price:String,
                @SerializedName("maximum_price")
                val maximum_price:String,
                @SerializedName("minimum_value")
                val minimum_value:String,
                @SerializedName("maximum_value")
                val maximum_value:String
)

fun BookModel.toBookEntity():BooksEntity{
    return BooksEntity(book, minimum_amount, maximum_amount, minimum_price, maximum_price, minimum_value, minimum_price)
}