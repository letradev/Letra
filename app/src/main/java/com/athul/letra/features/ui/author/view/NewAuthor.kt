package com.athul.letra.features.ui.newauthor.view

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.athul.letra.R
import com.athul.letra.databinding.FragmentSearchBinding
import com.athul.letra.features.ui.home.viewmodel.HomeViewModel
import com.athul.letra.features.ui.search.view.SearchFragment
import com.athul.letra.ui.basecomponent.views.BaseFragment
import javax.inject.Inject

class NewAuthor : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewmodel: HomeViewModel
    lateinit var binding: FragmentSearchBinding


    companion object {

        fun newInstance(): NewAuthor {
            val fragmentFirst = NewAuthor()
            val args = Bundle()
            fragmentFirst.setArguments(args)
            return fragmentFirst
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_new_author, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        getViewModelComponent().inject(this)
        super.onActivityCreated(savedInstanceState)
        viewmodel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
    }

}