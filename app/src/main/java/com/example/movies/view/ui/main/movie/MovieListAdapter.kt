package com.example.movies.view.ui.main.movie

import android.view.View
import com.example.movies.R
import com.example.movies.model.entity.Movie
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.BaseViewHolder
import com.skydoves.baserecyclerviewadapter.SectionRow

class MovieListAdapter(private val delegate: MovieListViewHolder.Delegate) : BaseAdapter() {
    init {
        addSection(ArrayList<Movie>())
    }

    fun addMovieList(resource: List<Movie>) {
        sections()[0].addAll(resource)
        notifyDataSetChanged()
    }

    override fun layout(sectionRow: SectionRow): Int {
        return R.layout.item_poster
    }

    override fun viewHolder(layout: Int, view: View): BaseViewHolder {
        return MovieListViewHolder(view, delegate)
    }


}