package com.example.movies

import android.annotation.SuppressLint
import android.content.Context
import com.example.movies.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber

class MoviesApplication : DaggerApplication() {

    private val component = DaggerAppComponent.builder().application(this).build()

    override fun onCreate() {
        super.onCreate()
        component.inject(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        context = this
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return component
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }
}