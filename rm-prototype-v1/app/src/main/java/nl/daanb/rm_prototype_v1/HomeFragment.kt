package nl.daanb.rm_prototype_v1

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import nl.daanb.rm_prototype_v1.databinding.FragmentHomeBinding
import nl.daanb.rm_prototype_v1.todos.Todo
import nl.daanb.rm_prototype_v1.todos.TodoAdapter

class HomeFragment : Fragment() {
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.bottomNavigation.selectedItemId = R.id.page_home
        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.page_achievements -> {
                    findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToAchievementsFragment())
                    true
                }
                R.id.page_roadmaps -> {
                    findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToRoadmapFragment3())
                    true
                }
                else -> false
            }
        }

        todoAdapter = TodoAdapter(mutableListOf(Todo("Tutorial #1", "video", true), Todo("Tutorial #2", "article", true), Todo("Tutorial #3"), Todo("Tutorial #4", "website"), Todo("Tutorial #5"), Todo("Tutorial #6", "video", true), Todo("Tutorial #7", "interview", true), Todo("Tutorial #8", "interview", true), Todo("Tutorial #9")))

        binding.rvTodos.adapter = todoAdapter
        binding.rvTodos.layoutManager = LinearLayoutManager(activity)

        binding.progressBar.progress = todoAdapter.getPercentageCompleted()

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.kebab_menu, menu);

        super.onCreateOptionsMenu(menu, inflater)
    }
}