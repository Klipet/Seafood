package com.example.dataterminal.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dataterminal.R
import com.example.dataterminal.data.Images
import com.example.dataterminal.data.ImagesProductX
import com.example.dataterminal.databinding.ItemSlideshowBinding
import com.smarteist.autoimageslider.SliderViewAdapter
import com.squareup.picasso.Picasso

class PhotoRAdapter() : SliderViewAdapter<PhotoRAdapter.ImageSliderViewHolder>(){

    private var images: List<String> = emptyList()

    class ImageSliderViewHolder(view: View) : SliderViewAdapter.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imSlide)
    }

    fun setImages(images: List<String>){
        this.images = images
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?): ImageSliderViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_slideshow, parent, false)
        return ImageSliderViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ImageSliderViewHolder?, position: Int) {
        val imageUrl = images[position]
        Glide.with(viewHolder!!.itemView)
            .load(imageUrl)
            .into(viewHolder.imageView)
    }


}