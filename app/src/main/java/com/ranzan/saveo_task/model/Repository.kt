package com.ranzan.saveo_task.model

import androidx.lifecycle.liveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.ranzan.saveo_task.model.api.MoviePagingSource
import com.ranzan.saveo_task.model.api.Network
import kotlinx.coroutines.Dispatchers

class Repository {
    fun getPopularMovies() = Pager(
        config = PagingConfig(
            pageSize = 20,
            maxSize = PagingConfig.MAX_SIZE_UNBOUNDED
        ),
        pagingSourceFactory = { MoviePagingSource() }
    ).liveData


    fun getUpcomingMovie() = liveData(Dispatchers.IO) {
        emit(Network.apiService.getUpcomingMovie().results)
    }
}