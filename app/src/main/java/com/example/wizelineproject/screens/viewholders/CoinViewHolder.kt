package com.example.wizelineproject.screens.viewholders

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.wizelineproject.R
import com.example.wizelineproject.domain.network.model.BookModel

class CoinViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val firstCoin: AppCompatImageView = view.findViewById(R.id.imgCoinOne)
    private val secondCoin: AppCompatImageView = view.findViewById(R.id.imgCoinTwo)
    private val text: TextView = view.findViewById(R.id.lblName)

    fun render(book: BookModel, firstCoinId: Int, secondCoinId: Int) {
        firstCoin.setBackgroundResource(firstCoinId)
        secondCoin.setBackgroundResource(secondCoinId)
        text.text = book.book
    }

}