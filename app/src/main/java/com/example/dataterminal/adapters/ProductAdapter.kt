package com.example.dataterminal.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dataterminal.R
import com.example.dataterminal.data.ProductX
import com.example.dataterminal.databinding.ItemMenuBinding
import com.squareup.picasso.Picasso




class ProductAdapter: ListAdapter <ProductX, ProductAdapter.Holder>(Comparator()) {
    class Holder(view: View): RecyclerView.ViewHolder(view){
        private val binding = ItemMenuBinding.bind(view)
        fun bind(productX: ProductX) = with(binding){
            Picasso.get().load(productX.images.toString()).into(imFood)
            tvNameFood.text = productX.title

        }

    }
    class Comparator: DiffUtil.ItemCallback<ProductX>(){
        override fun areItemsTheSame(oldItem: ProductX, newItem: ProductX): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProductX, newItem: ProductX): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }
}