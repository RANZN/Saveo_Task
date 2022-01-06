package com.ranzan.saveo_task.view.adapter

import com.ranzan.saveo_task.model.api.ResultsItem

interface ItemClickListener {
    fun onItemClick(resultsItem: ResultsItem)
}