package com.example.wizelineproject.domain.network.model

import com.google.gson.annotations.SerializedName

//For Bid and Ask
data class TransactionModel(
    @SerializedName("book")
    val book: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("amount")
    val amount: String
)
