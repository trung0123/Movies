package com.example.movies.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movies.factory.AppViewModelFactory
import com.example.movies.view.ui.main.movie.MovieListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
internal abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MovieListViewModel::class)
    internal abstract fun bindMainActivityViewModels(movieListViewModel: MovieListViewModel): ViewModel

//    @Binds
//    @IntoMap
//    @ViewModelKey(MovieDetailViewModel::class)
//    internal abstract fun bindMovieDetailViewModel(movieDetailViewModel: MovieDetailViewModel): ViewModel
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(TvDetailViewModel::class)
//    internal abstract fun bindTvDetailViewModel(tvDetailViewModel: TvDetailViewModel): ViewModel
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(PersonDetailViewModel::class)
//    internal abstract fun bindPersonDetailViewModel(personDetailViewModel: PersonDetailViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory

}