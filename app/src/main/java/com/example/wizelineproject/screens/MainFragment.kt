package com.example.wizelineproject.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wizelineproject.R
import com.example.wizelineproject.databinding.ActivityMainBinding
import com.example.wizelineproject.databinding.FragmentMainBinding
import com.example.wizelineproject.screens.adapters.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class MainFragment : Fragment() {

    @Inject
    lateinit var  viewPagerAdapter: ViewPagerAdapter
    private lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainBinding.inflate(layoutInflater)
        if(viewPagerAdapter==null)
            Log.e("log", "adapter es null")
        else
            Log.e("log", "todo bien "+viewPagerAdapter.count)
        binding.viewPager.adapter = viewPagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
        // Inflate the layout for this fragment
        return binding.getRoot()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onResume() {
        super.onResume()
        Log.e("log", "mainfragment")
        //binding.viewPager.adapter = viewPagerAdapter
        //binding.viewPager.refreshDrawableState()
        //binding.tabLayout.setupWithViewPager(binding.viewPager)
        // Inflate the layout for this fragment
        //return binding.getRoot()
    }

}