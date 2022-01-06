package com.ranzan.saveo_task.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ranzan.saveo_task.model.Network
import com.ranzan.saveo_task.model.ResultsItem

class MoviePagingSource : PagingSource<Int, ResultsItem>() {
    override fun getRefreshKey(state: PagingState<Int, ResultsItem>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResultsItem> {
        val pageNumber = params.key ?: 1

        val responseModel = Network.apiService.getPopularMovie(pageNumber)
        val dataList: List<ResultsItem> = responseModel.results as List<ResultsItem>
        return try {
            LoadResult.Page(
                data = dataList,
                prevKey = null,
                nextKey = if (dataList.isNullOrEmpty()) null else pageNumber + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}