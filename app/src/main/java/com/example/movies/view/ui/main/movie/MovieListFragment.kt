package com.example.movies.view.ui.main.movie


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movies.R
import com.example.movies.databinding.FragmentMovieListBinding
import com.example.movies.model.entity.Movie
import com.skydoves.baserecyclerviewadapter.RecyclerViewPaginator
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_movie_list.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class MovieListFragment : Fragment(), MovieListViewHolder.Delegate {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)
            .get(MovieListViewModel::class.java)
    }
    private lateinit var binding: FragmentMovieListBinding
    private lateinit var paginator: RecyclerViewPaginator
    private var page: Int = 0
    var threshold = 10

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_list, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUI()
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
        loadMore(page = 1)
    }

    private fun initializeUI() {
        recyclerView.adapter = MovieListAdapter(this)
        recyclerView.layoutManager = GridLayoutManager(context, 2)


        paginator = RecyclerViewPaginator(
            recyclerView = recyclerView,
            isLoading = { true },
            loadMore = { loadMore(it) },
            onLast = { true }

        )
        page = 1
        paginator.currentPage = page
    }

    private fun loadMore(page: Int) {
        viewModel.getMovieListValues(page)
    }

    override fun onItemClick(movie: Movie) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
