package com.example.taskuser.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskuser.databinding.ItemUserBinding
import com.example.taskuser.model.UserModel
import javax.inject.Inject

class ItemUserListAdapter @Inject constructor() : RecyclerView.Adapter<ItemUserListAdapter.ItemUserViewHolder>() {

    private var listUser = ArrayList<UserModel>()

    class ItemUserViewHolder(val binding : ItemUserBinding) : RecyclerView.ViewHolder(binding.root){
        val userNameText = binding.userNameText
        val userUserNameText = binding.userUserNameText
        val emailText = binding.emailText
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemUserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemUserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemUserViewHolder, position: Int) {
        val user = listUser[position]
        with(holder){
            userNameText.text=user.name
            userUserNameText.text=user.userName
            emailText.text=user.mail
        }
    }

    override fun getItemCount() = listUser.size

    fun update(listUser : ArrayList<UserModel>){
        this.listUser=listUser
        notifyDataSetChanged()
    }
}