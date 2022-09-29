package com.example.wizelineproject.domain.repository

import com.example.wizelineproject.domain.network.response.GenericArrayResponse
import com.example.wizelineproject.domain.network.response.GenericObjectResponse
import retrofit2.Retrofit
import java.lang.Exception
import javax.inject.Inject

abstract class GenericRepository<T : Any>() {

    @Inject
    lateinit var client: Retrofit
    @Inject
    open lateinit var api: T

    suspend fun <K> getResponseWithArray(
        callService: suspend () -> GenericArrayResponse<K>?,
        callback: (Boolean, List<K>) -> Unit
    ) {
        try {
            val call = callService()
            call?.let {
                call.payload?.let {
                    if (call.payload.size > 0) {
                        call.success?.let {
                            if (call.success.equals(true)) {
                                callback(true, call.payload)
                                return@getResponseWithArray
                            }
                        }
                    }
                }
            }
            var filler = ArrayList<K>()
            callback(false, filler)
        }catch (e:Exception){
            var filler = ArrayList<K>()
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
                        if (call.success.equals(true)) {
                            callback(true, call.payload)
                            return@getResponseWithObject
                        }
                    }
                }
            }
            callback(false, null)
        }catch (e:Exception){
            callback(false, null)
        }
    }

}