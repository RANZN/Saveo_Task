package com.ranzan.saveo_task.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ranzan.saveo_task.R
import com.ranzan.saveo_task.model.ResultsItem
import com.ranzan.saveo_task.viewmodel.TheViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ItemClickListener {

    private lateinit var viewModel: TheViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(TheViewModel::class.java)

        viewModel.getUpcomingMovie().observe(this, {
            viewPager.adapter = TheAdapter(it as ArrayList<ResultsItem>, this)
        })
    }

    override fun onItemClick(resultsItem: ResultsItem) {
        val intent = Intent(this, DetailedActivity::class.java)
        intent.putExtra("data", resultsItem)
        startActivity(intent)
    }
}