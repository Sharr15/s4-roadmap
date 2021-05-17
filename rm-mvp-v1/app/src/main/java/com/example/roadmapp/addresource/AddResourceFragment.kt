package com.example.roadmapp.addresource

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roadmapp.R
import com.example.roadmapp.databinding.FragmentAddResourceBinding

class AddResourceFragment: Fragment() {
    private lateinit var viewModel: AddResourceViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Instantiate ViewModel
        viewModel = ViewModelProvider(this).get(AddResourceViewModel::class.java)

        // Instantiate binding
        val binding: FragmentAddResourceBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_resource, container, false)

        // Set the ViewModel
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        // Assign adapter to RecyclerView
        binding.rvResults.adapter = viewModel.resultAdapter
        binding.rvResults.layoutManager = LinearLayoutManager(activity)

        // Return layout
        return binding.root
    }
}