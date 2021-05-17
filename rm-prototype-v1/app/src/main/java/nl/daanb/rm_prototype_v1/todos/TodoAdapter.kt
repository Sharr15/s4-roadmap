package nl.daanb.rm_prototype_v1.todos

import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_todo.view.*
import nl.daanb.rm_prototype_v1.R

class TodoAdapter(
    private val todos: MutableList<Todo>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>(){
    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_todo,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val curTodo = todos[position]
        holder.itemView.apply {
            todoTextView.text = curTodo.title + " - " + curTodo.type
            todoCheckBox.isChecked = curTodo.checked
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    public fun getPercentageCompleted(): Int {
        val total: Float = todos.size.toFloat()
        val checked = todos.filter { todo -> todo.checked }.size.toFloat()

        return ((checked/total)*100).toInt()
    }
}