package com.athul.letra.features.ui.song.view

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.athul.letra.R
import com.athul.letra.databinding.FragmentSearchBinding
import com.athul.letra.features.ui.home.viewmodel.HomeViewModel
import com.athul.letra.ui.basecomponent.views.BaseFragment
import javax.inject.Inject

class FavouriteSong : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewmodel: HomeViewModel
    lateinit var binding: FragmentSearchBinding


    companion object {

        fun newInstance(): FavouriteSong {
            val fragmentFirst = FavouriteSong()
            val args = Bundle()
            fragmentFirst.setArguments(args)
            return fragmentFirst
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_favourite_song, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        getViewModelComponent().inject(this)
        super.onActivityCreated(savedInstanceState)
        viewmodel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
    }

}