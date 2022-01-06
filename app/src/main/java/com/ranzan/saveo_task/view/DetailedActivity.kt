package com.ranzan.saveo_task.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ranzan.saveo_task.R
import com.ranzan.saveo_task.model.ResultsItem

class DetailedActivity : AppCompatActivity() {
    private lateinit var data: ResultsItem
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        if (intent != null) {
            data = intent.getSerializableExtra("data") as ResultsItem
        }
    }
}