package nl.daanb.rm_prototype_v1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_new_roadmap.*
import nl.daanb.rm_prototype_v1.databinding.FragmentNewRoadmapBinding
import nl.daanb.rm_prototype_v1.resources.Resource
import nl.daanb.rm_prototype_v1.resources.ResourceAdapter


class NewRoadmapFragment : Fragment() {
    private lateinit var resourceAdapter: ResourceAdapter
    private var isShowing: Boolean = false
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentNewRoadmapBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_roadmap, container, false)

        resourceAdapter = ResourceAdapter(mutableListOf())

        binding.rvResources.adapter = resourceAdapter
        binding.rvResources.layoutManager = LinearLayoutManager(activity)

        binding.btnCancel.setOnClickListener {
            findNavController().navigate(NewRoadmapFragmentDirections.actionNewRoadmapFragmentToRoadmapFragment())
        }

        binding.button3.setOnClickListener {
            findNavController().navigate(NewRoadmapFragmentDirections.actionNewRoadmapFragmentToRoadmapFragment())
        }

        binding.imageButton.setOnClickListener {
            if(!isShowing){
                resourceAdapter.add(Resource("Resource 1"))
                resourceAdapter.add(Resource("Resource 2"))
                resourceAdapter.add(Resource("Resource 3", "website"))
                resourceAdapter.add(Resource("Resource 4", "article"))
                resourceAdapter.add(Resource("Resource 5", "article"))
                resourceAdapter.add(Resource("Resource 6"))
                resourceAdapter.add(Resource("Resource 7"))
                resourceAdapter.add(Resource("Resource 8", "interview"))
                isShowing = true
            }
        }

        return binding.root
    }

}