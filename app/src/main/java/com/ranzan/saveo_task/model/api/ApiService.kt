package com.ranzan.saveo_task.model.api

import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "328c283cd27bd1877d9080ccb1604c91"

interface ApiService {

    @GET("3/discover/movie?api_key=$API_KEY")
    suspend fun getPopularMovie(@Query("page") pg: Int): ResponseModel

    @GET("3/movie/upcoming?api_key=$API_KEY")
    suspend fun getUpcomingMovie(): ResponseModel

}