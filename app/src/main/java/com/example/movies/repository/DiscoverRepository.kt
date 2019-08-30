package com.example.movies.repository

import com.example.movies.api.MovieNetwork
import com.example.movies.room.MovieDao
import com.example.movies.room.TvDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DiscoverRepository @Inject
constructor(val movieNetwork: MovieNetwork, val movieDao: MovieDao, val tvDao: TvDao) {
    init {
        Timber.d("Injection DiscoverRepository")
    }

    suspend fun loadMovies(page: Int) = withContext(Dispatchers.IO) {
        var list = movieDao.getMovieList(page)
        if (list.isEmpty()) {
            val movieRespone = movieNetwork.fetchDiscoverMovie(page)
            list = movieRespone.results
            list.forEach {
                it.page = page
            }
            movieDao.insertMovieList(list)
        }
        list
    }
}