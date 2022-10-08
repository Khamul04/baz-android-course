package com.example.wizelineproject.screens.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wizelineproject.R
import com.example.wizelineproject.domain.network.model.TransactionModel
import com.example.wizelineproject.screens.viewholders.TransactionViewHolder

class TransactionsRecyclerAdapter(private val transactions:List<TransactionModel>): RecyclerView.Adapter<TransactionViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TransactionViewHolder(layoutInflater.inflate(R.layout.transaction_item, parent, false))
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val item = transactions[position]
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return transactions.size
    }
}