package com.example.movies.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.movies.model.entity.Movie
import com.example.movies.model.entity.Person
import com.example.movies.model.entity.Tv
import com.example.movies.utils.*

@Database(entities = [Movie::class, Tv::class, Person::class], version = 3, exportSchema = false)

@TypeConverters(
    value = [(StringListConverter::class), (IntegerListConverter::class),
        (KeywordListConverter::class), (VideoListConverter::class), (ReviewListConverter::class)]
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvDao
    abstract fun peopleDao(): PeopleDao
}