package com.arash.altafi.coroutine.sample0.networkcall.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.arash.altafi.coroutine.databinding.ChildSingleNetworkCallWithImagesBinding
import com.arash.altafi.coroutine.sample0.networkcall.model.UserModel

class SingleNetworkCallWithImagesAdapter(private val userListList: List<UserModel>) :
    RecyclerView.Adapter<SingleNetworkCallWithImagesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ChildSingleNetworkCallWithImagesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setDataToViews(position)
    }

    override fun getItemCount(): Int {
        return userListList.size
    }

    inner class ViewHolder(private val binding: ChildSingleNetworkCallWithImagesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setDataToViews(position: Int) {
            binding.name.text = userListList[position].name
            binding.email.text = userListList[position].email
            binding.image.load(userListList[position].avatar)
        }
    }
}