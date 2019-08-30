/*
 * The MIT License (MIT)
 *
 * Designed and developed by 2018 skydoves (Jaewoong Eum)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.example.movies.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.model.entity.Movie
import com.example.movies.view.ui.main.movie.MovieListAdapter

@BindingAdapter("adapterMovieList")
fun bindAdapterMovieList(view: RecyclerView, resource: List<Movie>?) {
    if (resource != null) {
        val adapter = view.adapter as? MovieListAdapter
        adapter?.addMovieList(resource)
    }
}

//@BindingAdapter("adapterPersonList")
//fun bindAdapterPersonList(view: RecyclerView, resource: Resource<List<Person>>?) {
//    view.bindResource(resource) {
//        if (resource != null) {
//            val adapter = view.adapter as? PeopleAdapter
//            adapter?.addPeople(resource)
//        }
//    }
//}
//
//@BindingAdapter("adapterTvList")
//fun bindAdapterTvList(view: RecyclerView, resource: Resource<List<Tv>>?) {
//    view.bindResource(resource) {
//        if (resource != null) {
//            val adapter = view.adapter as? TvListAdapter
//            adapter?.addTvList(resource)
//        }
//    }
//}
//
//@BindingAdapter("adapterVideoList")
//fun bindAdapterVideoList(view: RecyclerView, resource: Resource<List<Video>>?) {
//    view.bindResource(resource) {
//        if (resource != null) {
//            val adapter = view.adapter as? VideoListAdapter
//            adapter?.addVideoList(resource)
//            if (resource.data?.isNotEmpty()!!) {
//                view.visible()
//            }
//        }
//    }
//}
//
//@BindingAdapter("adapterReviewList")
//fun bindAdapterReviewList(view: RecyclerView, resource: Resource<List<Review>>?) {
//    view.bindResource(resource) {
//        if (resource != null) {
//            val adapter = view.adapter as? ReviewListAdapter
//            adapter?.addReviewList(resource)
//            if (resource.data?.isNotEmpty()!!) {
//                view.visible()
//            }
//        }
//    }
//}
