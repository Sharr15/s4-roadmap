package nl.daanb.rm_prototype_v1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import nl.daanb.rm_prototype_v1.databinding.FragmentRoadmapBinding
import nl.daanb.rm_prototype_v1.roadmaps.Roadmap
import nl.daanb.rm_prototype_v1.roadmaps.RoadmapAdapter


class RoadmapFragment : Fragment() {
    private lateinit var roadmapAdapter: RoadmapAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentRoadmapBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_roadmap, container, false)

        binding.bottomNavigation.selectedItemId = R.id.page_roadmaps
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.page_achievements -> {
                    findNavController().navigate(RoadmapFragmentDirections.actionRoadmapFragmentToAchievementsFragment())
                    true
                }
                R.id.page_home -> {
                    findNavController().navigate(RoadmapFragmentDirections.actionRoadmapFragmentToHomeFragment())
                    true
                }
                else -> false
            }
        }

        roadmapAdapter = RoadmapAdapter(mutableListOf(Roadmap("Android Roadmap", 20), Roadmap("PWA Roadmap", 40), Roadmap("iOS Roadmap", 80)))

        binding.rvRoadmaps.adapter = roadmapAdapter
        binding.rvRoadmaps.layoutManager = LinearLayoutManager(activity)

        binding.fabNewRoadmap.setOnClickListener {
            findNavController().navigate(RoadmapFragmentDirections.actionRoadmapFragmentToNewRoadmapFragment())
        }

        return binding.root
    }

}