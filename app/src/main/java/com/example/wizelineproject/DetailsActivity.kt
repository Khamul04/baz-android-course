package com.example.wizelineproject

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.VisibleForTesting
import com.example.wizelineproject.databinding.ActivityDetailsBinding
import com.example.wizelineproject.viewmodel.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {
    @VisibleForTesting
    private val vModel: DetailsViewModel by viewModels()

    @VisibleForTesting
    private lateinit var binding: ActivityDetailsBinding
    var book = "btc_mxn"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPref = this.getSharedPreferences("DETAILS", Context.MODE_PRIVATE)
        book = sharedPref.getString("book", "btc_mxn") ?: "btc_mxn"
        vModel.ticker.observe(this) {
            binding.lblBook.text = it.book
            binding.lblVolume.text = it.volume
            binding.lblHigh.text = it.high
            binding.lblLow.text = it.low
            binding.lblLast.text = it.last
        }
    }

    override fun onResume() {
        super.onResume()
        vModel.getBooks(book)
    }
}