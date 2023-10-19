package com.example.fetchapplication.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fetchapplication.databinding.ActivityMainBinding
import com.example.fetchapplication.presentation.vm.JsonListViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: JsonListViewModel by viewModels()
    private lateinit var adapter: AdpJsonList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnFilter.setOnClickListener {
            viewModel.filterName()
        }
        binding.btnNoFilter.setOnClickListener {
            viewModel.NofilterName()
        }
        binding.recycler.layoutManager = LinearLayoutManager(this)
        viewModel.adpList.observe(this){
            adapter = it
            binding.recycler.adapter = it
        }
    }
}