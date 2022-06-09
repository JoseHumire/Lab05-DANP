package com.example.lab5.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.lab5.R
import com.example.lab5.data.Product
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter:RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var productList = emptyList<Product>()

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = productList[position]
        holder.itemView.id_txt.text = currentItem.id.toString()
        holder.itemView.productName_txt.text = currentItem.name
        holder.itemView.brand_txt.text = currentItem.brand
        holder.itemView.quantity_txt.text = currentItem.quantity

        holder.itemView.rowLayout.setOnClickListener {

        }

    }
    fun setData(product: List<Product>){
        this.productList = product
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return productList.size
    }


}