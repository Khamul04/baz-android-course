package com.example.wizelineproject.domain.network.model

import com.google.gson.annotations.SerializedName

data class OrderBook(
    @SerializedName("bids")
    val bids: List<TransactionModel>?,
    @SerializedName("asks")
    val asks: List<TransactionModel>?,
    @SerializedName("updated_at")
    val updateAt: String,
    @SerializedName("sequence")
    val sequence: String
)
