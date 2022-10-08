package com.example.wizelineproject.screens.viewholders

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

    fun render(book: BookModel){
        var prefix:Int
        if(book.book.startsWith("btc"))
            prefix = R.drawable.bitcoin
        else if(book.book.startsWith("mxn"))
            prefix = R.drawable.peso
        else if(book.book.startsWith("eth"))
            prefix = R.drawable.ethereum
        else if(book.book.startsWith("usd"))
            prefix = R.drawable.dolar
        else if(book.book.startsWith("ltc"))
            prefix = R.drawable.ltc
        else if(book.book.startsWith("xrp"))
            prefix = R.drawable.xrp
        else if(book.book.startsWith("bch"))
            prefix = R.drawable.bch
        else if(book.book.startsWith("bat"))
            prefix = R.drawable.bat
        else if(book.book.startsWith("mana"))
            prefix = R.drawable.mana
        else if(book.book.startsWith("tusd"))
            prefix = R.drawable.tusd
        else
            prefix = R.drawable.coin_generic

        var suffix:Int
        if(book.book.endsWith("btc"))
            suffix = R.drawable.bitcoin
        else if(book.book.endsWith("mxn"))
            suffix = R.drawable.peso
        else if(book.book.endsWith("eth"))
            suffix = R.drawable.ethereum
        else if(book.book.endsWith("usd"))
            suffix = R.drawable.dolar
        else
            suffix = R.drawable.coin_generic


        firstCoin.setBackgroundResource(prefix)
        secondCoin.setBackgroundResource(suffix)
        text.text = book.book
    }

    override fun onClick(v: View?) {
        Log.e("log", "click")
    }
}