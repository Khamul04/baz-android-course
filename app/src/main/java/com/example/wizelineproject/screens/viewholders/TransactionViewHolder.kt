package com.example.wizelineproject.screens.viewholders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wizelineproject.R
import com.example.wizelineproject.domain.network.model.TransactionModel
import com.example.wizelineproject.utils.addCurrencySymbol

class TransactionViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val lblName = view.findViewById<TextView>(R.id.lblName)
    private val lblPrice = view.findViewById<TextView>(R.id.lblPrice)
    private val lblAmount = view.findViewById<TextView>(R.id.lblAmount)

    fun render(transaction: TransactionModel) {
        lblName.text = transaction.book
        val stringToText = transaction.price.addCurrencySymbol()
        lblPrice.text = stringToText
        lblAmount.text = transaction.amount
    }
}
