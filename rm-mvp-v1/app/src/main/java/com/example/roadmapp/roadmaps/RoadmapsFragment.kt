package com.example.roadmapp.roadmaps

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
import com.example.roadmapp.databinding.RoadmapsFragmentBinding

class RoadmapsFragment : Fragment() {
    private lateinit var viewModel: RoadmapsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Instantiate ViewModel
        viewModel = ViewModelProvider(this).get(RoadmapsViewModel::class.java)

        // Instantiate binding
        val binding: RoadmapsFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.roadmaps_fragment, container, false)

        // Add navigation to the bottom bar
        binding.bottomNavigation.selectedItemId = R.id.page_roadmaps
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.page_home -> {
                    findNavController().navigate(RoadmapsFragmentDirections.actionRoadmapsFragmentToHomeFragment())
                    true
                }
                R.id.page_achievements -> {
                    findNavController().navigate(RoadmapsFragmentDirections.actionRoadmapsFragmentToAchievementFragment())
                    true
                }
                else -> false
            }
        }

        // Assign adapter to RecyclerView
        binding.rvRoadmaps.adapter = viewModel.roadmapsAdapter
        binding.rvRoadmaps.layoutManager = LinearLayoutManager(activity)

        // Add navigation to FloatingActionButton
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(RoadmapsFragmentDirections.actionRoadmapsFragmentToNewRoadmapFragment())
        }

        // Return layout
        return binding.root
    }
}