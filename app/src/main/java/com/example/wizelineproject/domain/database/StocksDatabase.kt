package com.example.wizelineproject.domain.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.wizelineproject.domain.database.dao.BooksDao
import com.example.wizelineproject.domain.database.entities.BooksEntity

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(BooksEntity::class), version = 1, exportSchema = false)
public abstract class StocksDatabase : RoomDatabase() {

    abstract fun getBooksDao(): BooksDao

}