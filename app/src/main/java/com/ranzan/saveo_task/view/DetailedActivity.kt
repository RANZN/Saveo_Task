package com.ranzan.saveo_task.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.ranzan.saveo_task.R
import com.ranzan.saveo_task.model.api.ResultsItem
import kotlinx.android.synthetic.main.activity_detailed.*

class DetailedActivity : AppCompatActivity() {
    private lateinit var data: ResultsItem
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        back.setOnClickListener {
            onBackPressed()
        }
        if (intent != null) {
            data = intent.getSerializableExtra("data") as ResultsItem

            data.apply {
                Glide.with(ivPoster).load("https://image.tmdb.org/t/p/w500${posterPath}")
                    .into(ivPoster)

                tvTitle.text = title
                tvData.text = "${originalLanguage.toString()} | ${releaseDate.toString()}"
                tvReviews.text = "Vote count: $voteCount"
                tvRating.text = "  (${voteAverage.toString()})"
                ratingBar.rating = (voteAverage!! / 2).toFloat()
                tvOverview.text = overview
            }
        }

    }
}