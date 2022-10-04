package com.example.wizelineproject.domain.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.wizelineproject.domain.database.entities.BooksEntity

@Dao
interface BooksDao {

    @Query("SELECT * FROM books_table ORDER BY book ASC")
    suspend fun getAlphabetizedBooks(): List<BooksEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(books:List<BooksEntity>)

    @Query("DELETE FROM books_table")
    suspend fun deleteAll()

}