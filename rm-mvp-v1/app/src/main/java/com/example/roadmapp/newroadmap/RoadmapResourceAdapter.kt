package com.example.roadmapp.newroadmap

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.roadmapp.R
import com.example.roadmapp.models.Resource
import kotlinx.android.synthetic.main.item_resource.view.*


class RoadmapResourceAdapter(resources: MutableList<Resource>): RecyclerView.Adapter<RoadmapResourceAdapter.RoadmapResourceViewHolder>() {
    class RoadmapResourceViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    private var resourceList = resources

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoadmapResourceViewHolder {
        return RoadmapResourceViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.item_resource,
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: RoadmapResourceViewHolder, position: Int) {
        val currentResource = resourceList[position]
        holder.itemView.apply {
            tv_resource_title.text = currentResource.title
            tv_resource_type.text = currentResource.type
            cb_resource.visibility = View.INVISIBLE
            val params = cb_resource.layoutParams as ConstraintLayout.LayoutParams
            params.setMargins(8, 0, 0, 0)
            iv_resource_item.layoutParams = params

            iv_resource_delete.setOnClickListener {
                resourceList.removeAt(position)
                notifyDataSetChanged()
            }

            Glide.with(this).load(currentResource.img).into(iv_resource_item)
        }
    }

    override fun getItemCount(): Int {
        return resourceList.size
    }
}