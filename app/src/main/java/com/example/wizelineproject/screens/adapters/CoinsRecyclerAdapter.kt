package com.example.wizelineproject.screens.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wizelineproject.R
import com.example.wizelineproject.domain.network.model.BookModel
import com.example.wizelineproject.screens.viewholders.CoinViewHolder

class CoinsRecyclerAdapter(val books:List<BookModel>):RecyclerView.Adapter<CoinViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CoinViewHolder(layoutInflater.inflate(R.layout.coins_item, parent, false))
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val item = books.get(position)
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return books.size
    }
}