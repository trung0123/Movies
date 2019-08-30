package com.example.movies.view.ui.main.movie

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.MoviesApplication
import com.example.movies.model.entity.Movie
import com.example.movies.repository.DiscoverRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieListViewModel @Inject
constructor(private val discoverRepository: DiscoverRepository) : ViewModel() {

    var movieListLiveData = MutableLiveData<List<Movie>>()

    fun getMovieListValues(page: Int) {
        launch({
            movieListLiveData.value = discoverRepository.loadMovies(page)
        }, {
            Toast.makeText(MoviesApplication.context, it.message, Toast.LENGTH_SHORT).show()
        })
    }

    private fun launch(block: suspend () -> Unit, error: suspend (Throwable) -> Unit) =
        viewModelScope.launch {
            try {
                block()
            } catch (e: Throwable) {
                error(e)
            }
        }
}