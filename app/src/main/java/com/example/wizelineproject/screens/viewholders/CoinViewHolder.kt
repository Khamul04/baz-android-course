package com.example.wizelineproject.screens.viewholders

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.wizelineproject.R
import com.example.wizelineproject.domain.network.model.BookModel

class CoinViewHolder(view: View):RecyclerView.ViewHolder(view), View.OnClickListener {

    val firstCoin = view.findViewById<AppCompatImageView>(R.id.imgCoinOne)
    val secondCoin = view.findViewById<AppCompatImageView>(R.id.imgCoinTwo)
    val text = view.findViewById<TextView>(R.id.lblName)

    init{
        view.setOnClickListener(this)
    }

    fun render(book: BookModel, firstCoinId: Int, secondCoinId:Int){
        firstCoin.setBackgroundResource(firstCoinId)
        secondCoin.setBackgroundResource(secondCoinId)
        text.text = book.book
    }

    override fun onClick(v: View?) {
        Log.e("log", "click")
    }
}