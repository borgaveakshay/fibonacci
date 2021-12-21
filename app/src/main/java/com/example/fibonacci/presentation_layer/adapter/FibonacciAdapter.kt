package com.example.fibonacci.presentation_layer.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fibonacci.R
import com.example.fibonacci.databinding.ListItemBinding

private val diffUtil = object : DiffUtil.ItemCallback<ULong>() {
    override fun areItemsTheSame(oldItem: ULong, newItem: ULong): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ULong, newItem: ULong): Boolean {
        return oldItem == newItem
    }
}


class FibonacciAdapter : ListAdapter<ULong, FibonacciAdapter.ViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataBindingUtil.inflate<ListItemBinding>(
            LayoutInflater.from(parent.context), R.layout.list_item, parent, false
        ).run {
            ViewHolder(this)
        }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))

    class ViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: ULong) {
            binding.data = data.toString()
        }
    }
}