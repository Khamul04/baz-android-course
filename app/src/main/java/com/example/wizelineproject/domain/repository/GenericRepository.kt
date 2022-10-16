package com.example.wizelineproject.domain.repository

import com.example.wizelineproject.domain.network.response.GenericArrayResponse
import com.example.wizelineproject.domain.network.response.GenericObjectResponse
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import java.lang.Exception
import javax.inject.Inject

abstract class GenericRepository<T : Any> {

    @Inject
    lateinit var client: Retrofit

    @Inject
    open lateinit var api: T

    @Inject
    lateinit var compositeDisposable: CompositeDisposable

    suspend fun <K> getResponseWithArray(
        callService: suspend () -> GenericArrayResponse<K>?,
        callback: (Boolean, List<K>) -> Unit
    ) {
        try {
            val call = callService()
            call?.let {
                call.payload?.let {
                    if (call.payload.isNotEmpty()) {
                        call.success?.let {
                            if (call.success == true) {
                                callback(true, call.payload)
                                return@getResponseWithArray
                            }
                        }
                    }
                }
            }
            val filler = ArrayList<K>()
            callback(false, filler)
        } catch (e: Exception) {
            val filler = ArrayList<K>()
            callback(false, filler)
        }
    }

    suspend fun <K> getResponseWithObject(
        callService: suspend () -> GenericObjectResponse<K>?,
        callback: (Boolean, K?) -> Unit
    ) {
        try {
            val call = callService()
            call?.let {
                call.payload?.let {
                    call.success?.let {
                        if (call.success == true) {
                            callback(true, call.payload)
                            return@getResponseWithObject
                        }
                    }
                }
            }
            callback(false, null)
        } catch (e: Exception) {
            callback(false, null)
        }
    }

    fun <K> getResponseRxJavaWithObject(
        callService: () -> Single<GenericObjectResponse<K>?>,
        callback: (Boolean, K?) -> Unit
    ) {
        val call = callService()
        compositeDisposable.add(
            call.subscribeOn(Schedulers.io()).subscribe(
                {
                    it?.let {
                        it.payload?.let { internal: K ->
                            it.success?.let { internal2: Boolean ->
                                if (it.success == true) {
                                    callback(true, it.payload)
                                }
                            }
                        }
                    }
                },
                {
                    callback(false, null)
                }
            )
        )
    }
}
