package com.example.roadmapp.achievements

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
import com.example.roadmapp.databinding.AchievementFragmentBinding

class AchievementFragment : Fragment() {
    private lateinit var viewModel: AchievementViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Instantiate ViewModel
        viewModel = ViewModelProvider(this).get(AchievementViewModel::class.java)

        // Instantiate binding
        val binding: AchievementFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.achievement_fragment, container, false)

        // Set the ViewModel
        binding.achievementViewModel = viewModel
        binding.lifecycleOwner = this

        // Add navigation to the bottom bar
        binding.bottomNavigation.selectedItemId = R.id.page_achievements
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.page_home -> {
                    findNavController().navigate(AchievementFragmentDirections.actionAchievementFragmentToHomeFragment())
                    true
                }
                R.id.page_roadmaps -> {
                    findNavController().navigate(AchievementFragmentDirections.actionAchievementFragmentToRoadmapsFragment())
                    true
                }
                else -> false
            }
        }

        // Assign adapter to RecyclerView
        binding.rvAchievements.adapter = viewModel.achievementAdapter
        binding.rvAchievements.layoutManager = LinearLayoutManager(activity)

        // Return the layout
        return binding.root
    }
}