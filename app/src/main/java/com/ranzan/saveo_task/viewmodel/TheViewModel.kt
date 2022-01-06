package com.ranzan.saveo_task.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ranzan.saveo_task.model.Repository

class TheViewModel(private val repo: Repository) : ViewModel() {

    fun getUpcomingMovie() = repo.getUpcomingMovie()

    fun getPopularMovies() = repo.getPopularMovies()

}

class ViewModelFactory(private val repo: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TheViewModel(repo) as T
    }

}
