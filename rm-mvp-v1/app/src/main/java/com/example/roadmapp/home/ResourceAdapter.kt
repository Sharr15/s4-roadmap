package com.example.roadmapp.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.roadmapp.R
import com.example.roadmapp.models.Resource
import kotlinx.android.synthetic.main.item_resource.view.*

class ResourceAdapter (resources: MutableList<Resource>): RecyclerView.Adapter<ResourceAdapter.ResourceViewHolder>(){
    class ResourceViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    private var resourceList = resources

    private var _progress = MutableLiveData<Int>()
    val progress: LiveData<Int>get() = _progress

    private var _max = MutableLiveData<Int>()
    val max: LiveData<Int>get() = _max

    init{
        updateProgress()
    }

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
        val currentResource = resourceList[position]
        holder.itemView.apply {
            tv_resource_title.text = currentResource.title
            tv_resource_type.text = currentResource.type
            cb_resource.isChecked = currentResource.done
            cb_resource.setOnCheckedChangeListener { _, b ->
                if(cb_resource.isChecked){
                    _progress.value = _progress.value?.plus(1)
                    resourceList[position].done = true
                } else if (!cb_resource.isChecked){
                    _progress.value = _progress.value?.minus(1)
                    resourceList[position].done = false
                }
            }

            iv_resource_delete.setOnClickListener {
                resourceList.remove(currentResource)
                updateProgress()
                notifyItemRemoved(position)
            }

            Glide.with(this)
                .load(currentResource.img)
                .into(iv_resource_item)
        }
    }

    private fun updateProgress(){
        _progress.value = resourceList.filter{resource ->  resource.done}.size
        _max.value = resourceList.size
    }

    override fun getItemCount(): Int {
        return resourceList.size
    }

}