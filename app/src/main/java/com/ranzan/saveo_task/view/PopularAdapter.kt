package com.ranzan.saveo_task.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ranzan.saveo_task.R
import com.ranzan.saveo_task.model.ResultsItem
import kotlinx.android.synthetic.main.pop_item_layout.view.*

class PopularAdapter : PagingDataAdapter<ResultsItem, PopularAdapter.MovieViewHolder>(diffUtil) {
    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ResultsItem>() {
            override fun areItemsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
                return oldItem == newItem
            }

        }

    }

    override fun onBindViewHolder(holder: PopularAdapter.MovieViewHolder, position: Int) {
        val resultsItem = getItem(position)
        resultsItem?.let {
            holder.setData(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularAdapter.MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pop_item_layout, parent, false)
        return MovieViewHolder(view)

    }


    class MovieViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun setData(item: ResultsItem) {
            Glide.with(view.image)
                .load("https://image.tmdb.org/t/p/w500${item.posterPath}")
                .placeholder(R.drawable.image_placeholder).into(view.image)
        }

    }
}