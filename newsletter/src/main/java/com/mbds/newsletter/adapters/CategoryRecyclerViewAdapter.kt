package com.mbds.newsletter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mbds.newsletter.R
import com.mbds.newsletter.model.Category
import com.mbds.newsletter.utils.CellClickListener

class CategoryRecyclerViewAdapter(private val dataset: List<Category>, private val cellClickListener: CellClickListener) :
    RecyclerView.Adapter<CategoryRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(val root: View) : RecyclerView.ViewHolder(root) {
        lateinit var category: Category
        fun bind(item: Category) {
            val txtName = root.findViewById<TextView>(R.id.category_name)
            val imageView = root.findViewById<ImageView>(R.id.category_image)
            txtName.text = item.label.capitalize()
            category = item

            Glide
                .with(root)
                .load(item.image)
                .fitCenter()
                .placeholder(R.drawable.placeholder)
                .into(imageView);
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val rootView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.category_item, parent, false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(
            dataset[position]
        )
        holder.itemView.setOnClickListener{
            cellClickListener.onCellClickListener(holder.category)
        }
    }

    override fun getItemCount(): Int = dataset.size
}

