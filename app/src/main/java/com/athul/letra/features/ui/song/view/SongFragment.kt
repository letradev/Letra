package com.athul.letra.features.ui.song.view

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.athul.letra.R
import com.athul.letra.application.AppConstants
import com.athul.letra.domain.database.AppDatabase
import com.athul.letra.databinding.FragmentSearchBinding
import com.athul.letra.features.ui.home.adaptor.FragmentAdaptor
import com.athul.letra.features.ui.home.viewmodel.HomeViewModel
import com.athul.letra.features.ui.search.view.LyricsFragment
import com.athul.letra.ui.basecomponent.views.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.doAsync
import javax.inject.Inject

class SongFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var appDatabase: AppDatabase


    lateinit var viewmodel: HomeViewModel
    lateinit var binding: FragmentSearchBinding
    private var fragmentadaptor: FragmentAdaptor? = null
    private var song_id: Long = -1

    companion object {

        fun newInstance(id: Long): SongFragment {
            val fragmentFirst = SongFragment()
            val args = Bundle()
            args.putLong(AppConstants.SONG_ID, id);
            fragmentFirst.setArguments(args)
            return fragmentFirst
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        song_id = arguments!!.getLong(AppConstants.SONG_ID)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_new_song, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        getViewModelComponent().inject(this)
        super.onActivityCreated(savedInstanceState)
        viewmodel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)

        fragmentadaptor = FragmentAdaptor(activity!!.getSupportFragmentManager())

        view_pager.adapter = fragmentadaptor


        doAsync {
            var data = appDatabase.CommonDao().getSongs(song_id)

            data.lyrics.orEmpty().forEach {
                fragmentadaptor!!.AddFragment(LyricsFragment.newInstance(it))
            }
            fragmentadaptor!! .notifyDataSetChanged()

        }


    }

}