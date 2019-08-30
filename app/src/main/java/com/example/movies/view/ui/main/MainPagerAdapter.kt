package com.example.movies.view.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.movies.view.ui.main.movie.MovieListFragment
import com.example.movies.view.ui.main.person.PersonListFragment
import com.example.movies.view.ui.main.tv.TvListFragment

class MainPagerAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> MovieListFragment()
            1 -> TvListFragment()
            else -> PersonListFragment()
        }
    }

    override fun getCount() = 3
}