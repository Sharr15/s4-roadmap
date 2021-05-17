package nl.daanb.rm_prototype_v1.achievements

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_achievement.view.*
import nl.daanb.rm_prototype_v1.R

class AchievementAdapter(private val achievements: MutableList<Achievement>): RecyclerView.Adapter<AchievementAdapter.AchievementViewHolder>() {
    class AchievementViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

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
        val curAchievement = achievements[position]
        holder.itemView.apply {
            tvAchievementTitle.text = curAchievement.title
            tvAchievementsPoints.text = curAchievement.points.toString() + " pts."
        }

        if(curAchievement.achieved == false){
            holder.itemView.apply {
                tvAchievementTitle.setTextColor(Color.GRAY)
                tvAchievementsPoints.setTextColor(Color.GRAY)
            }
        }
    }

    override fun getItemCount(): Int {
        return achievements.size
    }

    public fun getTotal(): String {
        var total = 0
        val completedAchievements = achievements.filter{achievement -> achievement.achieved }
        for (achievement in completedAchievements) {
            total += achievement.points
        }
        return "$total pts."
    }
}