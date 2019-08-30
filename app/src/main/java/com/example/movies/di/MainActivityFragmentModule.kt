package com.example.movies.di

import com.example.movies.view.ui.main.movie.MovieListFragment
import com.example.movies.view.ui.main.person.PersonListFragment
import com.example.movies.view.ui.main.tv.TvListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityFragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeMovieListFragment(): MovieListFragment

    @ContributesAndroidInjector
    abstract fun contributeTvListFragment(): TvListFragment

    @ContributesAndroidInjector
    abstract fun contributePersonListFragment(): PersonListFragment
}