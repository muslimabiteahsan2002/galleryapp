package com.muslima.mygallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.muslima.mygallery.databinding.ItemImageBinding
import com.squareup.picasso.Picasso

class MyGalleryAdapter(private val listener:ItemClickedListener):ListAdapter<ShowData,MyGalleryAdapter.MGalleryViewHolder>(comparator) {
    class MGalleryViewHolder(var binding: ItemImageBinding):RecyclerView.ViewHolder(binding.root)
    companion object {
        val comparator = object :DiffUtil.ItemCallback<ShowData>(){
            override fun areItemsTheSame(oldItem: ShowData, newItem: ShowData): Boolean {
                return oldItem==newItem
            }

            override fun areContentsTheSame(oldItem: ShowData, newItem: ShowData): Boolean {
                return oldItem==newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MGalleryViewHolder {
        return MGalleryViewHolder(ItemImageBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MGalleryViewHolder, position: Int) {
        getItem(position).let {
            with(holder.binding) {
                Picasso.get().load(it.path).into(showImage)
            }
            holder.itemView.setOnClickListener {
                listener.itemClicked(position)
            }
        }
    }
}