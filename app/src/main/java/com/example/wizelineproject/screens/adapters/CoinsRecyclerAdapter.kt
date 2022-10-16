package com.example.wizelineproject.screens.adapters

import android.content.Context
import android.content.ContextWrapper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.wizelineproject.R
import com.example.wizelineproject.domain.network.model.BookModel
import com.example.wizelineproject.screens.viewholders.CoinViewHolder
import com.example.wizelineproject.utils.getFirstCurrencyName
import com.example.wizelineproject.utils.getSecondCurrencyName

class CoinsRecyclerAdapter(private val books: List<BookModel>) :
    RecyclerView.Adapter<CoinViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.coins_item, parent, false)

        return CoinViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        val item = books[position]
        holder.itemView.setOnClickListener {
            val sharedPref = ((it.context as ContextWrapper).baseContext).getSharedPreferences(
                "DETAILS",
                Context.MODE_PRIVATE
            )
            with(sharedPref.edit()) {
                putString("book", books[position].book)
                apply()
            }
            Navigation.findNavController(it).navigate(R.id.detailsActivity)
        }
        var idFirst = holder.itemView.context.resources.getIdentifier(
            books[position].book.getFirstCurrencyName(),
            "drawable",
            holder.itemView.context.packageName
        )
        if (idFirst == 0)
            idFirst = holder.itemView.context.resources.getIdentifier(
                "coin_generic",
                "drawable",
                holder.itemView.context.packageName
            )

        var idSecond = holder.itemView.context.resources.getIdentifier(
            books[position].book.getSecondCurrencyName(),
            "drawable",
            holder.itemView.context.packageName
        )
        if (idSecond == 0) {
            idSecond = holder.itemView.context.resources.getIdentifier(
                "coin_generic",
                "drawable",
                holder.itemView.context.packageName
            )
        }

        holder.render(item, idFirst, idSecond)
    }

    override fun getItemCount(): Int {
        return books.size
    }
}
