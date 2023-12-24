package com.rajit.staggeredrecyclerviewexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rajit.staggeredrecyclerviewexample.databinding.StaggeredItemviewBinding
import com.rajit.staggeredrecyclerviewexample.model.Product
import com.rajit.staggeredrecyclerviewexample.util.MyDiffUtil

class MyCustomAdapter: RecyclerView.Adapter<MyCustomAdapter.MyCustomViewHolder>() {

    private var list: List<Product> = arrayListOf()

    inner class MyCustomViewHolder(val binding: StaggeredItemviewBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCustomViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = StaggeredItemviewBinding.inflate(inflater, parent, false)
        return MyCustomViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyCustomViewHolder, position: Int) {
        val currentItem = list[position]

        holder.binding.apply {

            productIv.load(currentItem.image)

            // Product Title
            productTitleTv.text = currentItem.title

            // Product Price
            productPriceTv.text = "₹ ${currentItem.price}"

            // Product Rating
            productRatingTv.text = currentItem.rating.rate.toString()
        }
    }

    fun submitList(newList: List<Product>) {
        val diffUtil = MyDiffUtil(list, newList)
        val diffUtilResult = DiffUtil.calculateDiff(diffUtil)
        list = newList
        diffUtilResult.dispatchUpdatesTo(this)
    }

}