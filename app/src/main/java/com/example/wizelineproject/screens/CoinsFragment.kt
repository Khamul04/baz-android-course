package com.example.wizelineproject.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.example.wizelineproject.R
import com.example.wizelineproject.databinding.FragmentAsksBinding
import com.example.wizelineproject.databinding.FragmentCoinsBinding
import com.example.wizelineproject.viewmodel.CoinsListViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CoinsFragment @Inject constructor(): Fragment() {

    private val vModel: CoinsListViewModel by viewModels()
    private lateinit var binding: FragmentCoinsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCoinsBinding.inflate(inflater,container,false);
        vModel.monedas.observe(this.viewLifecycleOwner){
            it.forEach {
                Log.e("log", "book: "+it.book)
            }
        }
        return binding.getRoot();
    }

    override fun onResume() {
        super.onResume()
        vModel.getBooks()
    }
}