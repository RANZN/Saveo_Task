package com.ranzan.saveo_task.pagination

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingConfig.Companion.MAX_SIZE_UNBOUNDED
import androidx.paging.liveData

class MovieRepository {

    fun getMovieList() = Pager(
        config = PagingConfig(
            pageSize = 40,
            maxSize = MAX_SIZE_UNBOUNDED
        ),
        pagingSourceFactory = { MoviePagingSource() }
    ).liveData

}