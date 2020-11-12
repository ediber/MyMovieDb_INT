package com.e.mymoviedb_int.Screen0

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.e.mymoviedb_int.R

class Fragment0 : Fragment() {

    companion object {
        fun newInstance() = Fragment0()
    }

  //  private lateinit var viewModel: Fragment0ViewModel

    private val viewModel: Fragment0ViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }
        ViewModelProviders.of(this, ViewModelFactory0(activity.application))
            .get(Fragment0ViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment0_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        val adapter = MovieDbAdapter()
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(context)

        view.findViewById<View>(R.id.btn_refresh).setOnClickListener(View.OnClickListener {
            viewModel.refreshMovieDBData()
        })



        viewModel.movies.observe(viewLifecycleOwner, Observer {
            adapter.data = it
        })


    }

}