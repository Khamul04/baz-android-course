package com.example.wizelineproject.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wizelineproject.databinding.FragmentBidsBinding
import com.example.wizelineproject.screens.adapters.TransactionsRecyclerAdapter
import com.example.wizelineproject.viewmodel.BidsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BidsFragment @Inject constructor() : Fragment() {

    private val vModel: BidsViewModel by viewModels()
    private lateinit var binding: FragmentBidsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBidsBinding.inflate(inflater, container, false)
        initObservers()
        binding.recyclerBids.layoutManager = LinearLayoutManager(this.context)
        binding.btnBids.setOnClickListener {
            vModel.getBids(binding.autoCompleteBids.text.toString())
        }
        return binding.root
    }

    private fun initObservers() {
        vModel.bids.observe(this.viewLifecycleOwner) {
            binding.recyclerBids.adapter =
                TransactionsRecyclerAdapter(vModel.bids.value ?: listOf())
        }

        vModel.names.observe(this.viewLifecycleOwner) {
            val arrayAdapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_list_item_1,
                vModel.names.value as MutableList<String>
            )
            binding.autoCompleteBids.setAdapter(arrayAdapter)
        }
    }

    override fun onResume() {
        super.onResume()
        vModel.getBooksNames()
    }

}