package com.example.androidlab2.adapter


import androidx.recyclerview.widget.DiffUtil
import com.example.androidlab2.model.Celebrity

class CelebrityDiffUtil : DiffUtil.ItemCallback<Celebrity>() {
    override fun areItemsTheSame(oldItem: Celebrity, newItem: Celebrity): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Celebrity, newItem: Celebrity): Boolean {
        return oldItem == newItem
    }
}
