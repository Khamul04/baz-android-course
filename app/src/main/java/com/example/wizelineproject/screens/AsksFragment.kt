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
import com.example.wizelineproject.viewmodel.AsksViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AsksFragment @Inject constructor(): Fragment() {

    private val vModel: AsksViewModel by viewModels()
    private lateinit var binding:FragmentAsksBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAsksBinding.inflate(inflater,container,false);
        vModel.asks.observe(this.viewLifecycleOwner){
            it?.forEach {
                Log.e("log", "Asks: "+it.toString())
            }
        }
        return binding.getRoot();
    }

    override fun onResume() {
        super.onResume()
        vModel.getAsks("btc_mxn")
    }
}