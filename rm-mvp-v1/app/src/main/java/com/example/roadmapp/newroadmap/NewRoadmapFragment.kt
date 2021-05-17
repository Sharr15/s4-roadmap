package com.example.roadmapp.newroadmap

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roadmapp.R
import com.example.roadmapp.databinding.NewRoadmapFragmentBinding

class NewRoadmapFragment : Fragment() {
    private lateinit var viewModel: NewRoadmapViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Instantiate ViewModel
        viewModel = ViewModelProvider(this).get(NewRoadmapViewModel::class.java)

        // Instantiate binding
        val binding: NewRoadmapFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.new_roadmap_fragment, container, false)

        // Bind viewMode to the Fragment
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        // Event for canceling addition
        binding.btnNewRoadmapCancel.setOnClickListener {
            findNavController().navigate(NewRoadmapFragmentDirections.actionNewRoadmapFragmentToRoadmapsFragment())
        }

        // Event for adding a roadmap
        binding.btnNewRoadmapAdd.setOnClickListener {
            findNavController().navigate(NewRoadmapFragmentDirections.actionNewRoadmapFragmentToAddResourceFragment())
        }

        // Assign adapter to RecyclerView
        binding.rvResources.adapter = viewModel.roadmapResourceAdapter
        binding.rvResources.layoutManager = LinearLayoutManager(activity)

        // Return layout
        return binding.root
    }

}