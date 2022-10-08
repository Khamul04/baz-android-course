package com.example.wizelineproject.domain.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.wizelineproject.domain.database.dao.BooksDao
import com.example.wizelineproject.domain.database.entities.BooksEntity

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = [BooksEntity::class], version = 1, exportSchema = false)
abstract class StocksDatabase : RoomDatabase() {

    abstract fun getBooksDao(): BooksDao

}