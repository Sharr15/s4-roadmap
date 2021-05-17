package nl.daanb.rm_prototype_v1.resources

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_achievement.view.*
import kotlinx.android.synthetic.main.item_resource.view.*
import nl.daanb.rm_prototype_v1.R
import nl.daanb.rm_prototype_v1.achievements.Achievement

class ResourceAdapter(private val resources: MutableList<Resource>): RecyclerView.Adapter<ResourceAdapter.ResourceViewHolder>() {
    class ResourceViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResourceViewHolder {
        return ResourceViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_resource,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ResourceViewHolder, position: Int) {
        val curResource = resources[position]
        holder.itemView.apply {
            tvResourceTitle.text = curResource.title + " - " + curResource.type
        }

    }

    override fun getItemCount(): Int {
        return resources.size
    }

    public fun add(resource: Resource){
        resources.add(resource)
        notifyItemInserted(resources.size - 1)
    }

}