package com.example.roadmapp.achievements

import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.roadmapp.R
import com.example.roadmapp.models.Achievement
import kotlinx.android.synthetic.main.item_achievement.view.*

class AchievementAdapter(private var achievements: MutableList<Achievement>): RecyclerView.Adapter<AchievementAdapter.AchievementViewHolder>() {
    class AchievementViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    init {
        achievements.sortBy { it.points }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AchievementViewHolder {
        return AchievementViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_achievement,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AchievementViewHolder, position: Int) {
        val currentAchievement = achievements[position]
        holder.itemView.apply {
            tv_achievement_title.text = currentAchievement.title
            tv_achievement_points.text = currentAchievement.points.toString()

            when(currentAchievement.points){
                5 -> iv_achievement_points.setColorFilter(ContextCompat.getColor(context, R.color.bronze), PorterDuff.Mode.MULTIPLY)
                10 -> iv_achievement_points.setColorFilter(ContextCompat.getColor(context, R.color.silver), PorterDuff.Mode.MULTIPLY)
                15 -> iv_achievement_points.setColorFilter(ContextCompat.getColor(context, R.color.gold), PorterDuff.Mode.MULTIPLY)
            }

            if(!currentAchievement.achieved){
                tv_achievement_points.setTextColor(Color.GRAY)
                tv_achievement_title.setTextColor(Color.GRAY)
                iv_achievement_points.alpha = 0.5F
            }
        }
    }

    override fun getItemCount(): Int {
        return achievements.size
    }

    fun getTotal(): Int {
        var total = 0
        val completedAchievements = achievements.filter{achievement -> achievement.achieved }
        for (achievement in completedAchievements) {
            total += achievement.points
        }
        return total
    }
}