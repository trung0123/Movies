package com.example.movies.di

import android.app.Application
import androidx.annotation.NonNull
import androidx.room.Room
import com.example.movies.room.AppDatabase
import com.example.movies.room.MovieDao
import com.example.movies.room.PeopleDao
import com.example.movies.room.TvDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PersistenceModule {

    @Provides
    @Singleton
    fun provideDatabase(@NonNull application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "Movies.db")
            .allowMainThreadQueries().build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(@NonNull database: AppDatabase): MovieDao {
        return database.movieDao()
    }

    @Provides
    @Singleton
    fun provideTvDao(@NonNull database: AppDatabase): TvDao {
        return database.tvDao()
    }

    @Provides
    @Singleton
    fun providePeopleDao(@NonNull database: AppDatabase): PeopleDao {
        return database.peopleDao()
    }
}