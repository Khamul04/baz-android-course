package com.example.wizelineproject.modules

import android.content.Context
import androidx.room.Room
import com.example.wizelineproject.domain.database.StocksDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    private const val STOCKS_DATABASE_NAME = "stocks_database"

    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, StocksDatabase::class.java, STOCKS_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideBookDao(db: StocksDatabase) =
        db.getBooksDao()
}