package com.e.mymoviedb_int

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

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

        viewModel.movies.observe(viewLifecycleOwner, Observer {
            val a = it
        })

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.btn_refresh).setOnClickListener(View.OnClickListener {
            viewModel.refreshMovieDBData()
        })
    }

}