package com.example.roadmapp.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roadmapp.R
import com.example.roadmapp.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Instantiate ViewModel
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        // Instantiate binding
        val binding: HomeFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)

        // Set the ViewModel
        binding.homeViewModel = viewModel
        binding.lifecycleOwner = this

        // Add navigation to the bottom bar
        binding.bottomNavigation.selectedItemId = R.id.page_home
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.page_achievements -> {
                    findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToAchievementFragment())
                    true
                }
                R.id.page_roadmaps -> {
                    findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToRoadmapsFragment())
                    true
                }
                else -> false
            }
        }

        // Enable Kebab menu
        setHasOptionsMenu(true)

        // Assign adapter to RecyclerView
        binding.rvResources.adapter = viewModel.resourceAdapter
        binding.rvResources.layoutManager = LinearLayoutManager(activity)

        // Return layout
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        // Inflate Kebab menu
        inflater.inflate(R.menu.kebab_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Assign onClick events to the items in the kebab menu
        return when (item.itemId) {
            R.id.menu_export -> {
                viewModel.exportToCalendar()
                true
            }
            R.id.menu_settings -> {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToSettingsFragment())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}