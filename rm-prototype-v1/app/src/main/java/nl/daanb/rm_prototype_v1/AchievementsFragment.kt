package nl.daanb.rm_prototype_v1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_achievements.*
import nl.daanb.rm_prototype_v1.achievements.Achievement
import nl.daanb.rm_prototype_v1.achievements.AchievementAdapter
import nl.daanb.rm_prototype_v1.databinding.FragmentAchievementsBinding


class AchievementsFragment : Fragment() {
    private lateinit var achievementAdapter: AchievementAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentAchievementsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_achievements, container, false)

        binding.bottomNavigation.selectedItemId = R.id.page_achievements
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.page_home -> {
                    findNavController().navigate(AchievementsFragmentDirections.actionAchievementsFragmentToHomeFragment())
                    true
                }
                R.id.page_roadmaps -> {
                    findNavController().navigate(AchievementsFragmentDirections.actionAchievementsFragmentToRoadmapFragment())
                    true
                }
                else -> false
            }
        }

        achievementAdapter = AchievementAdapter(mutableListOf(
                Achievement("First roadmap", 5, true),
                Achievement("Add more than 5 resources", 5, true),
                Achievement("Add more than 10 resources", 10),
                Achievement("Finish first roadmap", 10),
                Achievement("Export a roadmap", 20),
                Achievement("Share a roadmap", 15, true),
                Achievement("Delete a roadmap", 10, true),
                Achievement("Complete 5 roadmaps", 25),
                Achievement("Edit a roadmap"),
                Achievement("Create an account", 10, true),
                Achievement("Check items 5 days in a row", 5, true),
                Achievement("Check items 10 days in a row", 10),
                Achievement("Check items 15 days in a row", 15),
                Achievement("Complete a roadmap",5,true)
        ))

        binding.rvAchievements.adapter = achievementAdapter
        binding.rvAchievements.layoutManager = LinearLayoutManager(activity)

        binding.tvTotal.text = achievementAdapter.getTotal()

        return binding.root
    }

}