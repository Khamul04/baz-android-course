package com.example.wizelineproject.domain.network.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class HttpLogginInterceptorStock : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val request = original.newBuilder()
            .header("User-Agent", "WizelineProject")
            .build()
        return chain.proceed(request)
    }
}
