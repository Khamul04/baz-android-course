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
import com.example.wizelineproject.databinding.FragmentBidsBinding
import com.example.wizelineproject.databinding.FragmentCoinsBinding
import com.example.wizelineproject.viewmodel.BidsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BidsFragment @Inject constructor(): Fragment() {

    private val vModel: BidsViewModel by viewModels()
    private lateinit var binding: FragmentBidsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBidsBinding.inflate(inflater,container,false);
        vModel.bids.observe(this.viewLifecycleOwner){
            it?.forEach {
                Log.e("log", "Bids: "+it.toString())
            }
        }
        return binding.getRoot();
    }

    override fun onResume() {
        super.onResume()
        vModel.getBids("btc_mxn")
    }

}