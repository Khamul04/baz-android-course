package com.example.wizelineproject.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wizelineproject.databinding.FragmentCoinsBinding
import com.example.wizelineproject.screens.adapters.CoinsRecyclerAdapter
import com.example.wizelineproject.viewmodel.CoinsListViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CoinsFragment @Inject constructor() : Fragment() {

    private val vModel: CoinsListViewModel by viewModels()
    private lateinit var binding: FragmentCoinsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoinsBinding.inflate(inflater, container, false)
        binding.recycler.layoutManager = LinearLayoutManager(this.context)
        vModel.monedas.observe(this.viewLifecycleOwner) {
            binding.recycler.adapter = CoinsRecyclerAdapter(vModel.monedas.value ?: listOf())
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        vModel.getBooks()
    }
}
