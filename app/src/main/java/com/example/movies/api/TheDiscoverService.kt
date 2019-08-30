package com.example.movies.api

import com.example.movies.model.network.DiscoverMovieResponse
import com.example.movies.model.network.DiscoverTvResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TheDiscoverService {

    @GET("/3/discover/movie?language=en&sort_by=popularity.desc")
    fun fetchDiscoverMovie(@Query("page") page: Int): Call<DiscoverMovieResponse>

    @GET("/3/discover/tv?language=en&sort_by=popularity.desc")
    fun fetchDiscoverTv(@Query("page") page: Int): Call<DiscoverTvResponse>
}