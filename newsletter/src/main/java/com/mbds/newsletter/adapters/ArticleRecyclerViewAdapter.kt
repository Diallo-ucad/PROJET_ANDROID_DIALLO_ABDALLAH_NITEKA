package com.mbds.newsletter.adapters

import android.text.format.DateUtils
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.mbds.newsletter.R

import com.mbds.newsletter.model.ArticleItem
import java.util.*

class ArticleRecyclerViewAdapter(
    private val values: List<ArticleItem>
)
    : RecyclerView.Adapter<ArticleRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.article_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        val description: String = when(item.description != null){
            true -> item.description
            else -> ""
        }

        val titleAuthor = item.title.split("-")
        holder.contentView.text = titleAuthor[0]
        holder.descriptionView.text = description
        holder.authorView.text = when(titleAuthor[1].length <= 25){
            true -> titleAuthor[1]
            else -> item.author
        }
        holder.dateView.text = DateUtils.getRelativeTimeSpanString(
                item.publishedAt.time,
            Date().time,
            DateUtils.MINUTE_IN_MILLIS,
            DateUtils.FORMAT_ABBREV_RELATIVE
        )
        Glide
            .with(holder.view)
            .load(item.urlToImage)
            .fitCenter()
            .placeholder(R.drawable.placeholder)
            .into(holder.imgView);
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val contentView: TextView = view.findViewById(R.id.article_title)
        val imgView: ImageView = view.findViewById(R.id.article_img)
        val descriptionView: TextView = view.findViewById(R.id.article_description)
        val authorView: TextView = view.findViewById(R.id.article_author)
        val dateView: TextView = view.findViewById(R.id.article_date)

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }
}