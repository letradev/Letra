package com.athul.letra.features.ui.search.view

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.text.Html
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
import android.os.Build
import android.support.v7.widget.LinearLayoutManager
import android.text.Spanned
import android.text.method.ScrollingMovementMethod
import android.widget.LinearLayout
import com.athul.letra.domain.database.tables.Keys
import com.athul.letra.domain.pojo.LyricXml
import com.athul.letra.features.ui.lyrics.adaptor.LyricsAdaptor
import com.thoughtworks.xstream.XStream

import org.jetbrains.anko.doAsync


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

    private var key: Keys? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        getViewModelComponent().inject(this)
        super.onActivityCreated(savedInstanceState)
        viewmodel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)


        doAsync {

            key = viewmodel.getKeyForLyricsId(lyrics.index)
        }

        // tv_lyrics.setHtml(lyrics.lyric)
        //tv_lyrics.movementMethod = ScrollingMovementMethod()
        // tv_lyrics.typeface = FontBinder[lyrics.font.toLowerCase()]
        // tv_lyrics.setKeyLyric(lyric = lyrics.lyric, key = key)
        toast(lyrics.font)
        val xstream = XStream()


        val inputAsString = (lyrics.lyric)
        xstream.alias("lyric", LyricXml::class.java)
        xstream.addImplicitCollection(LyricXml::class.java, "verse", String::class.java)
        var ly: LyricXml = xstream.fromXML(inputAsString) as LyricXml

        tv_chorus.text = ly.getChrous().replace("//br//","\n")
        rv_lyrics.layoutManager = LinearLayoutManager(context)
        rv_lyrics.adapter = LyricsAdaptor(ly, listener = {

        });


    }


}