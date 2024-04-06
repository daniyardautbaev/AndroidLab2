package com.example.androidlab2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.androidlab2.databinding.ItemCelebrityBinding
import com.example.androidlab2.model.Celebrity


class CelebrityAdapter : ListAdapter<Celebrity, CelebrityAdapter.ViewHolder>(CelebrityDiffUtil()) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            ItemCelebrityBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemCelebrityBinding) : RecyclerView.ViewHolder(binding.root) {
        private val context = binding.root.context

        fun bind(celebrity: Celebrity) {
            binding.name.text = "Name: ${celebrity.name}"
            binding.netWorth.text = "NetWorth: ${celebrity.netWorth}"
            binding.gender.text = "gender: ${celebrity.gender}"
            binding.nationality.text = "nationality: ${celebrity.nationality}"
            binding.height.text = "height: ${celebrity.height}"
            binding.birthday.text = "birthday: ${celebrity.birthday}"


        }
    }
}