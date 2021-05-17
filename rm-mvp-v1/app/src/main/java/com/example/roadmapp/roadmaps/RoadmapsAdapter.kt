package com.example.roadmapp.roadmaps

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.roadmapp.R
import com.example.roadmapp.models.Roadmap
import kotlinx.android.synthetic.main.item_roadmap.view.*
import java.util.*


class RoadmapsAdapter (roadmaps: MutableList<Roadmap>, private var indexSelected: Int = 0): RecyclerView.Adapter<RoadmapsAdapter.RoadmapViewHolder>(){
    class RoadmapViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    private var roadmapList = roadmaps
    private var progress = 0
    private var max = 25

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoadmapViewHolder {
        return RoadmapViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.item_roadmap,
                        parent,
                        false
                )
        )
    }

    override fun getItemCount(): Int {
        return roadmapList.size
    }

    override fun onBindViewHolder(holder: RoadmapViewHolder, position: Int) {
        progress = 0
        val currentRoadmap = roadmapList[position]
        max = currentRoadmap.resources.size

        for (Resource in currentRoadmap.resources) {
            if(Resource.done){
                progress++
            }
        }

        if(position == 0){
            holder.itemView.apply{
                cl_roadmaps.setBackgroundColor(ContextCompat.getColor(context, R.color.secondary))
            }
        } else {
            holder.itemView.apply {
                cl_roadmaps.setBackgroundColor(Color.WHITE)
            }
        }

        holder.itemView.apply {
            tv_roadmap_name.text = currentRoadmap.title
            Glide.with(this).load(currentRoadmap.resources[0].img).into(iv_roadmaps_thumbnail)
            pgb_roadmaps.progress = progress
            pgb_roadmaps.max = max
        }
        holder.itemView.setOnClickListener {
            indexSelected = position
            Collections.swap(roadmapList, indexSelected, 0)
            notifyDataSetChanged()
        }
    }
}