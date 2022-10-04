package com.example.wizelineproject.domain.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "books_table")
data class BooksEntity(
    @PrimaryKey @ColumnInfo(name = "book") val name: String,
    @ColumnInfo(name = "minimum_amount")
    val minimum_amount: String,
    @ColumnInfo(name = "maximum_amount")
    val maximum_amount: String,
    @ColumnInfo(name = "minimum_price")
    val minimum_price: String,
    @ColumnInfo(name = "maximum_price")
    val maximum_price: String,
    @ColumnInfo(name = "minimum_value")
    val minimum_value: String,
    @ColumnInfo(name = "maximum_value")
    val maximum_value: String
)
