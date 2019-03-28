package com.chethan.demoproject.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.chethan.demoproject.ProductFamily
import com.chethan.demoproject.R


class ProductDetailAdapter(private val productFamily: ProductFamily) :
    RecyclerView.Adapter<ProductDetailAdapter.ViewHolder>() {
    private var onItemClickListener: ItemClickListener? = null

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.adapter_products_details, p0, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return productFamily.products.size;
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.name?.text = productFamily.products[position].name
        viewHolder.count?.text = productFamily.products[position].description
        val imageUrl = "http://mobcategories.s3-website-eu-west-1.amazonaws.com"+productFamily.products[position].url
        Glide.with(viewHolder.imageView.context).load(imageUrl).into(viewHolder.imageView)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.tvName)
        val count = itemView.findViewById<TextView>(R.id.tvCount)
        val imageView = itemView.findViewById<ImageView>(R.id.imageView);

        init {
            itemView.setOnClickListener {
                onItemClickListener?.onItemClick(itemView, 0)
            }
        }
    }


    fun setItemClickListener(clickListener: ItemClickListener) {
        onItemClickListener = clickListener
    }

    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }
}