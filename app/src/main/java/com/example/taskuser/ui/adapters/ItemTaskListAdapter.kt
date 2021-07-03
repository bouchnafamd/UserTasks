package com.example.taskuser.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskuser.databinding.ItemTaskBinding
import com.example.taskuser.model.TaskModel
import javax.inject.Inject

class ItemTaskListAdapter @Inject constructor() : RecyclerView.Adapter<ItemTaskListAdapter.ItemViewHolder>() {

    private var listTask = ArrayList<TaskModel>()

    class ItemViewHolder(val binding : ItemTaskBinding): RecyclerView.ViewHolder(binding.root){
        val taskTitleText = binding.taskTitleText
        val taskCompletedImageView = binding.taskCompletedImageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val task = listTask[position]
        with(holder){
            taskTitleText.text=task.title
            taskCompletedImageView.setImageResource(
                if(task.completed) android.R.drawable.checkbox_on_background
                else android.R.drawable.checkbox_off_background)
        }
    }

    override fun getItemCount() = listTask.size

    fun update(listTask : ArrayList<TaskModel>){
        this.listTask=listTask
        notifyDataSetChanged()
    }
}