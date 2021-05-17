package com.example.roadmapp.addresource

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roadmapp.R
import com.example.roadmapp.models.Result
import kotlinx.android.synthetic.main.item_result.view.*

class ResultAdapter(private val results: MutableList<Result>): RecyclerView.Adapter<ResultAdapter.ResultViewHolder>() {
    class ResultViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        return ResultViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_result,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val currentResult = results[position]
        holder.itemView.apply {
            tv_result_title.text = currentResult.title
            tv_result_type.text = currentResult.type
        }
    }

    override fun getItemCount(): Int {
        return results.size
    }
}