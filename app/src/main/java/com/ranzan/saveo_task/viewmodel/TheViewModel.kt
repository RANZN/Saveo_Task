package com.ranzan.saveo_task.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.ranzan.saveo_task.model.Network
import com.ranzan.saveo_task.pagination.MovieRepository
import kotlinx.coroutines.Dispatchers

class TheViewModel(private val repository: MovieRepository) : ViewModel() {

    fun getUpcomingMovie() = liveData(Dispatchers.IO) {
        emit(Network.apiService.getUpcomingMovie().results)
    }

    fun getPopularMovies() = repository.getMovieList()

}

class ViewModelFactory(private val repo: MovieRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TheViewModel(repo) as T
    }

}