package com.example.dataterminal.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dataterminal.InfoFood
import com.example.dataterminal.R
import com.example.dataterminal.data.ProductX
import com.example.dataterminal.databinding.ItemMenuBinding
import com.squareup.picasso.Picasso



class ProductAdapter(private val onClick: (ProductX) -> Unit): ListAdapter <ProductX, ProductAdapter.Holder>(Comparator()) {
    class Holder(view: View, private val onClick: (ProductX) -> Unit): RecyclerView.ViewHolder(view){
        private val binding = ItemMenuBinding.bind(view)

        fun bind(productX: ProductX) = with(binding) {

                tvBrend.text = productX.brand
                tvNameFood.text = productX.title
                tvPrice.text = productX.price.toString()
                Picasso.get().load(productX.thumbnail).into(imPhoto)


                binding.cvFoodInfo.setOnClickListener {
                    onClick(productX)
                }
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
        return Holder(view, onClick)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }


}
