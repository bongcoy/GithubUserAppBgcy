package com.example.githubuserappbgcy.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.githubuserappbgcy.R
import com.example.githubuserappbgcy.databinding.ItemUserBinding

class ListUserAdapter (private val listUser: ArrayList<User>) : RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {
    private lateinit var binding: ItemUserBinding

    inner class ListViewHolder(binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val user = listUser[position]
        Glide.with(holder.itemView.context)
            .load(user.avatar)
            .apply(RequestOptions.overrideOf(R.dimen.avatar_small,R.dimen.avatar_small))
            .into(holder.binding.iv_avatar)
        binding.tvFollowerNumber.text =
    }

    override fun getItemCount(): Int = listUser.size

}