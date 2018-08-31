package com.athul.letra.features.ui.search.view

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.athul.letra.R
import com.athul.letra.application.AppConstants
import com.athul.letra.domain.database.tables.Lyrics
import com.athul.letra.databinding.FragmentSearchBinding
import com.athul.letra.features.ui.home.viewmodel.HomeViewModel
import com.athul.letra.ui.basecomponent.views.BaseFragment
import com.athul.letra.utils.ext.toast
import com.github.nitrico.fontbinder.FontBinder
import kotlinx.android.synthetic.main.fragment_lyrics.*
import javax.inject.Inject

class LyricsFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewmodel: HomeViewModel
    lateinit var binding: FragmentSearchBinding


    companion object {

        fun newInstance(lyrics: Lyrics): LyricsFragment {
            val fragmentFirst = LyricsFragment()
            val args = Bundle()
            args.putParcelable(AppConstants.LYRICS_KEY, lyrics)
            fragmentFirst.arguments = args
            return fragmentFirst
        }
    }

    private lateinit var lyrics: Lyrics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            lyrics = arguments!!.getParcelable(AppConstants.LYRICS_KEY)
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_lyrics, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        getViewModelComponent().inject(this)
        super.onActivityCreated(savedInstanceState)
        viewmodel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)

        tv_lyrics.text = lyrics.lyrics
        tv_lyrics.typeface = FontBinder[lyrics.font.toLowerCase()]
        toast(lyrics.font)

    }

}