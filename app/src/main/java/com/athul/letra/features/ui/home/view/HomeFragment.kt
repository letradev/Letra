package com.athul.letra.features.ui.home.view

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.athul.letra.R
import com.athul.letra.databinding.FragmentHomeBinding
import com.athul.letra.features.ui.home.adaptor.FragmentAdaptor
import com.athul.letra.features.ui.home.viewmodel.HomeViewModel
import com.athul.letra.features.ui.search.view.SearchFragment
import com.athul.letra.ui.basecomponent.views.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

/**
 * A placeholder fragment containing a simple view.
 */
class HomeFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewmodel: HomeViewModel
    lateinit var binding: FragmentHomeBinding

    private var fragmentadaptor: FragmentAdaptor? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        getViewModelComponent().inject(this)
        super.onActivityCreated(savedInstanceState)
        viewmodel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)

        fragmentadaptor = FragmentAdaptor(activity!!.getSupportFragmentManager())
        fragmentadaptor!!.AddFragment(SearchFragment.newInstance())
        view_pager.adapter = fragmentadaptor

    }
}
