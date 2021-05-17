package nl.daanb.rm_prototype_v1.roadmaps

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_roadmap.view.*
import kotlinx.android.synthetic.main.item_todo.view.*
import nl.daanb.rm_prototype_v1.R

class RoadmapAdapter(private val roadmaps: MutableList<Roadmap>, private var indexSelected: Int = 0): RecyclerView.Adapter<RoadmapAdapter.RoadmapViewHolder>() {
    class RoadmapViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoadmapAdapter.RoadmapViewHolder {
        return RoadmapViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_roadmap,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RoadmapViewHolder, position: Int) {
        val curRoadmap = roadmaps[position]
        holder.itemView.apply {
            tvTitle.text = curRoadmap.title
            pbRoadmap.progress = curRoadmap.progress
        }

        holder.itemView.setOnClickListener {
            indexSelected = position
            notifyDataSetChanged()
        }

        if(indexSelected == position){
            holder.itemView.apply{
                container_roadmap.setBackgroundColor(ContextCompat.getColor(context, R.color.secondary))
            }
        } else {
            holder.itemView.apply {
                container_roadmap.setBackgroundColor(Color.WHITE)
            }
        }
    }

    override fun getItemCount(): Int {
        return roadmaps.size
    }
}