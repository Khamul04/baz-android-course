package com.example.wizelineproject.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wizelineproject.databinding.FragmentAsksBinding
import com.example.wizelineproject.screens.adapters.TransactionsRecyclerAdapter
import com.example.wizelineproject.viewmodel.AsksViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AsksFragment @Inject constructor() : Fragment() {

    private val vModel: AsksViewModel by viewModels()
    private lateinit var binding: FragmentAsksBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAsksBinding.inflate(inflater, container, false)
        initObservers()
        binding.recyclerAsks.layoutManager = LinearLayoutManager(this.context)
        binding.btnAsks.setOnClickListener {
            vModel.getAsks(binding.autoCompleteAsks.text.toString())
        }
        return binding.root
    }

    private fun initObservers() {
        vModel.asks.observe(this.viewLifecycleOwner) {
            binding.recyclerAsks.adapter =
                TransactionsRecyclerAdapter(vModel.asks.value ?: listOf())
        }

        vModel.names.observe(this.viewLifecycleOwner) {
            val arrayAdapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_list_item_1,
                vModel.names.value as MutableList<String>
            )
            binding.autoCompleteAsks.setAdapter(arrayAdapter)
        }
    }

    override fun onResume() {
        super.onResume()
        vModel.getBooksNames()
    }
}