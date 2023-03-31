package com.example.barashek

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.barashek.databinding.ItemBarashekBinding

class SelectedBarashekAdapter(val selectedBarashekList: ArrayList<Barashek>) :
    Adapter<SelectedBarashekAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ItemBarashekBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val item = selectedBarashekList[adapterPosition]
            binding.barashekIv.loadImage(item.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemBarashekBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return selectedBarashekList.size
    }
}