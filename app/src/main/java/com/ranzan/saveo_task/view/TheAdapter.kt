package com.ranzan.saveo_task.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ranzan.saveo_task.R
import com.ranzan.saveo_task.model.ResultsItem
import kotlinx.android.synthetic.main.item_layout.view.*

class TheAdapter(
    private val list: ArrayList<ResultsItem>,
    private val itemClickListener: ItemClickListener
) :
    RecyclerView.Adapter<TheAdapter.TheViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TheViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return TheViewHolder(view, itemClickListener)
    }

    override fun onBindViewHolder(holder: TheViewHolder, position: Int) {
        holder.setData(list[position])
    }

    override fun getItemCount(): Int = list.size

    class TheViewHolder(private val view: View, private val itemClickListener: ItemClickListener) :
        RecyclerView.ViewHolder(view) {
        fun setData(resultsItem: ResultsItem) {
            Glide.with(view.backDropImage)
                .load("https://image.tmdb.org/t/p/w500${resultsItem.backdropPath}")
                .placeholder(R.drawable.image_placeholder).into(view.backDropImage)
            Glide.with(view.posterImage)
                .load("https://image.tmdb.org/t/p/w500${resultsItem.posterPath}")
                .into(view.posterImage)

            view.layout.setOnClickListener {
                itemClickListener.onItemClick(resultsItem)
            }

        }
    }
}