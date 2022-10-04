package com.example.wizelineproject.screens.adapters

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.wizelineproject.R
import com.example.wizelineproject.domain.network.model.BookModel
import com.example.wizelineproject.screens.viewholders.CoinViewHolder


class CoinsRecyclerAdapter(val books:List<BookModel>):RecyclerView.Adapter<CoinViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.coins_item, parent, false)
        view.setOnClickListener {
            darClick()
        }
        return CoinViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val item = books.get(position)
        holder.itemView.setOnClickListener {
            val sharedPref = ((it.context as ContextWrapper).baseContext).getSharedPreferences("DETAILS", Context.MODE_PRIVATE)
            with (sharedPref.edit()) {
                putString("book", books.get(position).book)
                apply()
            }
            Navigation.findNavController(it).navigate(R.id.detailsActivity)
        }
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    private fun darClick(){

    }
}