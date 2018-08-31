package com.athul.letra.features.ui.search.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.athul.letra.R
import com.athul.letra.application.AppConstants
import com.athul.letra.domain.database.tables.Song
import com.athul.letra.databinding.FragmentSearchBinding
import com.athul.letra.features.ui.home.HomeActivity
import com.athul.letra.features.ui.home.viewmodel.HomeViewModel
import com.athul.letra.features.ui.search.adaptor.SearchAdaptor
import com.athul.letra.features.ui.song.SongActivity
import com.athul.letra.ui.basecomponent.views.BaseFragment
import com.athul.letra.utils.ext.*
import kotlinx.android.synthetic.main.fragment_search.*
import javax.inject.Inject
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.DividerItemDecoration.VERTICAL


class SearchFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewmodel: HomeViewModel
    lateinit var binding: FragmentSearchBinding


    companion object {

        fun newInstance(): SearchFragment {
            val fragmentFirst = SearchFragment()
            val args = Bundle()
            fragmentFirst.setArguments(args)
            return fragmentFirst
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        getViewModelComponent().inject(this)
        super.onActivityCreated(savedInstanceState)
        viewmodel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)




        recycler_view.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false);

        search_edt.onChanged {

            viewmodel.getSongsByKeyword(it)!!.observe(this, Observer {
                setAdaptor(it!!)
            })
        }
    }

    private fun setAdaptor(songs: List<Song>) {
        val itemDecor = DividerItemDecoration(context, VERTICAL)
        recycler_view.addItemDecoration(itemDecor)

        recycler_view.adapter = SearchAdaptor(songs) {
            var bundle: Bundle = Bundle()
            bundle.putLong(AppConstants.SONG_ID, it.id!!)
            movetoActivity(activity as HomeActivity, SongActivity::class.java, bundle)

        }
    }
}