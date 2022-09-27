package com.example.wizelineproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.tabs.TabLayout
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.wizelineproject.databinding.ActivityMainBinding
import com.example.wizelineproject.domain.model.Book
import com.example.wizelineproject.domain.model.Ticker
import com.example.wizelineproject.domain.repository.CriptosRepository
import com.example.wizelineproject.domain.repository.GenericRepository
import com.example.wizelineproject.domain.service.CriptomonedasServices
import com.example.wizelineproject.modules.AsksFragmentAnnotation
import com.example.wizelineproject.modules.BidsFragmentAnnotation
import com.example.wizelineproject.modules.CoinsFragmentAnnotation
import com.example.wizelineproject.screens.adapters.ViewPagerAdapter
import com.example.wizelineproject.viewmodel.AsksViewModel
import com.example.wizelineproject.viewmodel.BidsViewModel
import com.example.wizelineproject.viewmodel.CoinsListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var  viewPagerAdapter: ViewPagerAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPager.adapter = viewPagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)

    }
}