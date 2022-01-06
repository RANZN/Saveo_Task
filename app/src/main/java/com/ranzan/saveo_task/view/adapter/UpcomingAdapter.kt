package com.ranzan.saveo_task.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ranzan.saveo_task.R
import com.ranzan.saveo_task.model.api.ResultsItem
import kotlinx.android.synthetic.main.item_layout.view.*

class UpcomingAdapter(
    private val list: ArrayList<ResultsItem>,
    private val itemClickListener: ItemClickListener
) :
    RecyclerView.Adapter<UpcomingAdapter.UpcomingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return UpcomingViewHolder(view, itemClickListener)
    }

    override fun onBindViewHolder(holder: UpcomingViewHolder, position: Int) {
        holder.setData(list[position])
    }

    override fun getItemCount(): Int = list.size

    class UpcomingViewHolder(private val view: View, private val itemClickListener: ItemClickListener) :
        RecyclerView.ViewHolder(view) {
        fun setData(resultsItem: ResultsItem) {
            Glide.with(view.backDropImage).load("https://image.tmdb.org/t/p/w500${resultsItem.backdropPath}")
                .placeholder(R.drawable.image_placeholder).into(view.backDropImage)

            Glide.with(view.posterImage).load("https://image.tmdb.org/t/p/w500${resultsItem.posterPath}")
                .into(view.posterImage)

            view.layout.setOnClickListener {
                itemClickListener.onItemClick(resultsItem)
            }
        }
    }
}