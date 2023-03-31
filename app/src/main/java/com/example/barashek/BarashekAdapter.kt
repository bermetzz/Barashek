package com.example.barashek

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.barashek.databinding.ItemBarashekBinding


class BarashekAdapter(val barashekList: ArrayList<Barashek>, val onClick: (position: Int) -> Unit) :
    Adapter<BarashekAdapter.ViewHolder>() {

    private val selectedPhotos = mutableListOf<Barashek>()

    fun getSelectedPhotos(): List<Barashek> {
        return selectedPhotos.toList()
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
        return barashekList.size
    }

    inner class ViewHolder(private val binding: ItemBarashekBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val item = barashekList[adapterPosition]
            binding.apply {
                barashekIv.loadImage(item.image)
            }
            itemView.setOnClickListener {
                onClick(adapterPosition)
                item.isSelected = !item.isSelected
                if (item.isSelected) {
                    binding.barashekIv.alpha = 0.5f
                    selectedPhotos.add(item)
                } else if (selectedPhotos.contains(item)) {
                    selectedPhotos.remove(item)
                    binding.barashekIv.alpha = 1.0f
                } else {
                    binding.barashekIv.alpha = 1.0f
                }
            }
        }
    }
}