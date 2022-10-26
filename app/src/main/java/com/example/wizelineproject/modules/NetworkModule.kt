package com.example.wizelineproject.modules

import com.example.wizelineproject.domain.database.dao.BooksDao
import com.example.wizelineproject.domain.network.interceptors.HttpLogginInterceptorStock
import com.example.wizelineproject.domain.network.service.CriptomonedasServices
import com.example.wizelineproject.domain.repository.BooksRepository
import com.example.wizelineproject.domain.repository.TransactionsRepository
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.disposables.CompositeDisposable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [DatabaseModule::class])
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val interceptorPropio = HttpLogginInterceptorStock()
        return OkHttpClient.Builder().addInterceptor(interceptorPropio).addInterceptor(interceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(httpClient)
            .baseUrl("https://api.bitso.com/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provoidesCriptomonedasServices(retrofit: Retrofit): CriptomonedasServices {
        return retrofit.create(CriptomonedasServices::class.java)
    }

    @Singleton
    @Provides
    fun provideBooksRepository(
        retrofit: Retrofit,
        criptomonedasServices: CriptomonedasServices,
        dao: BooksDao,
        disposable: CompositeDisposable
    ): BooksRepository {
        val repo = BooksRepository()
        repo.configRepository(retrofit, criptomonedasServices, dao, disposable)
        return repo
    }

    @Singleton
    @Provides
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Singleton
    @Provides
    fun provideTransactionsRepository(
        retrofit: Retrofit,
        criptomonedasServices: CriptomonedasServices,
        dao: BooksDao
    ): TransactionsRepository {
        val repo = TransactionsRepository()
        repo.configRepository(retrofit, criptomonedasServices, dao)
        return repo
    }
}
