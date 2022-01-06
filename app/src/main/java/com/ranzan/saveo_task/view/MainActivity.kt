package com.ranzan.saveo_task.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.ranzan.saveo_task.R
import com.ranzan.saveo_task.model.Repository
import com.ranzan.saveo_task.model.api.ResultsItem
import com.ranzan.saveo_task.view.adapter.ItemClickListener
import com.ranzan.saveo_task.view.adapter.PopularAdapter
import com.ranzan.saveo_task.view.adapter.UpcomingAdapter
import com.ranzan.saveo_task.viewmodel.TheViewModel
import com.ranzan.saveo_task.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), ItemClickListener {

    private lateinit var viewModel: TheViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repo = Repository()
        viewModel = ViewModelProvider(this, ViewModelFactory(repo)).get(TheViewModel::class.java)

        setViewPager()
        setRecyclerView()

    }

    private fun setViewPager() {
        viewModel.getUpcomingMovie().observe(this, {
            viewPager.adapter = UpcomingAdapter(it as ArrayList<ResultsItem>, this)
            progressBar.visibility = View.GONE
        })
    }


    private fun setRecyclerView() {
        val popularAdapter = PopularAdapter(this)
        val gridLayout = GridLayoutManager(this, 3)
        recyclerView.apply {
            layoutManager = gridLayout
            adapter = popularAdapter
        }

        viewModel.getPopularMovies().observe(this, Observer {
            CoroutineScope(Dispatchers.IO).launch {
                popularAdapter.submitData(it)
            }
        })
    }

    override fun onItemClick(resultsItem: ResultsItem) {
        val intent = Intent(this, DetailedActivity::class.java)
        intent.putExtra("data", resultsItem)
        startActivity(intent)
    }
}
