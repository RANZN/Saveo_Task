package com.ranzan.saveo_task.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ranzan.saveo_task.model.Network
import kotlinx.coroutines.Dispatchers

class TheViewModel : ViewModel() {

    fun getUpcomingMovie() = liveData(Dispatchers.IO) {
        emit(Network.apiService.getUpcomingMovie().results)
    }

    fun getPopularMovies() = liveData(Dispatchers.IO) {
        emit(Network.apiService.getPopularMovie(1).results)
    }


}