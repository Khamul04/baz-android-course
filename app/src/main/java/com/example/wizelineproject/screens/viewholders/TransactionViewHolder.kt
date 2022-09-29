package com.example.wizelineproject.screens.viewholders

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.wizelineproject.R
import com.example.wizelineproject.domain.network.model.BookModel
import com.example.wizelineproject.domain.network.model.TransactionModel

class TransactionViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val lblName = view.findViewById<TextView>(R.id.lblName)
    val lblPrice = view.findViewById<TextView>(R.id.lblPrice)
    val lblAmount = view.findViewById<TextView>(R.id.lblAmount)

    fun render(transaction: TransactionModel) {
        lblName.text = transaction.book
        lblPrice.text = "$"+transaction.price
        lblAmount.text = transaction.amount
    }
}