package com.mirkamol.amazonbeginner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mirkamol.amazonbeginner.databinding.ItemProductBinding

class ProductAdapter(private val products: ArrayList<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(val bindind: ItemProductBinding) : RecyclerView.ViewHolder(bindind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val bindind = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(bindind)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bindind.apply {
            Glide.with(imageProduct.context).asBitmap().load(product.image).into(imageProduct)
            tvTitleProduct.text = product.name
            tvCategoryProduct.text = product.category

        }
    }

    override fun getItemCount(): Int {
        return  products.size
    }
}