package com.example.wizelineproject.domain.network.response

import com.google.gson.annotations.SerializedName

data class GenericArrayResponse<T>(
    @SerializedName("success")
    val success:Boolean?,
    @SerializedName("payload")
    val payload:List<T>?
    )
