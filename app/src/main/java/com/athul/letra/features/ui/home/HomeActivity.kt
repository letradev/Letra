package com.athul.letra.features.ui.home

import android.app.Activity
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.view.Gravity
import android.view.MenuItem
import com.athul.letra.R
import com.athul.letra.application.AppConstants
import com.athul.letra.domain.Repo
import com.athul.letra.domain.database.AppDatabase
import com.athul.letra.domain.database.tables.Lyrics
import com.athul.letra.domain.database.tables.Song
import com.athul.letra.domain.parser.VSongs
import com.athul.letra.databinding.ActivityHomeBinding
import com.athul.letra.domain.repository.ApiResquest
import com.athul.letra.features.ui.home.viewmodel.HomeViewModel
import com.athul.letra.features.ui.newauthor.view.NewAuthor
import com.athul.letra.features.ui.search.view.SearchFragment
import com.athul.letra.features.ui.song.view.FavouriteSong
import com.athul.letra.features.ui.song.view.NewSongFragment
import com.athul.letra.ui.basecomponent.views.BaseActivity
import com.athul.letra.utils.ext.*
import com.google.gson.Gson
import fr.arnaudguyon.xmltojsonlib.XmlToJson
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.content_home.*
import org.jetbrains.anko.doAsync
import java.io.BufferedReader
import java.io.IOException
import javax.inject.Inject

class HomeActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var appDatabase: AppDatabase

    lateinit var viewModel: HomeViewModel

    @Inject
    lateinit var apiResquest: ApiResquest

    val binding: ActivityHomeBinding by lazy {
        DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home)
    }

    private lateinit var searchFragment: SearchFragment
    private lateinit var newSongFragment: NewSongFragment
    private lateinit var newAuthorFragment: NewAuthor
    private lateinit var favouriteSongFragment: FavouriteSong


    override fun onCreate(savedInstanceState: Bundle?) {
        getViewModelComponent().inject(this)
        setfullscreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
        setToolbar(toolbar, AppConstants.APPLICATION_NAME, false)
        nav_view.setNavigationItemSelectedListener(this)
        observers()
        setupFragments()

        drawer_layout.setViewScale(Gravity.START, 0.9f);
        drawer_layout.setRadius(Gravity.START, 35f);
        drawer_layout.setViewElevation(Gravity.START, 20f);
        nav_view.setCheckedItem(R.id.nav_search)

        replaceFragment(searchFragment, R.id.fragment)




        doAsync {

            populate()

            if (apiResquest != null) {

                var re = apiResquest.getSong();
                // print(re.toString())
            }

        }
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    private fun observers() {

    }


    private fun setupFragments() {
        searchFragment = SearchFragment.newInstance();
        newSongFragment = NewSongFragment.newInstance();
        newAuthorFragment = NewAuthor.newInstance();
        favouriteSongFragment = FavouriteSong.newInstance();


        addFragment(searchFragment, R.id.fragment);
        addFragment(newAuthorFragment, R.id.fragment);
        addFragment(newSongFragment, R.id.fragment);


    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        toastLong(item.title.toString())


        when (item.itemId) {


            R.id.nav_search -> {
                replaceFragment(searchFragment, R.id.fragment)
            }
            R.id.nav_new_song -> {
                replaceFragment(newSongFragment, R.id.fragment)
            }
            R.id.nav_new_author -> {
                replaceFragment(newAuthorFragment, R.id.fragment)
            }
            R.id.nav_favourite -> {
                replaceFragment(favouriteSongFragment, R.id.fragment)
            }
        }


        drawer_layout.closeDrawer(GravityCompat.START);

        return true;
    }

    private fun populate() {
        var repo: Repo = Repo(appDatabase)
        var ff: Long = repo.getTotalCount()
        if (ff > 0) {
            return
        }


        var string: String = "{}"

        var iss = assets.open("malayalamplus.xml")
        try {

            string = iss.bufferedReader().use(BufferedReader::readText)

        } catch (e: IOException) {

        } finally {

        }

        val xmlToJson = XmlToJson.Builder(string).build()
        val jsonObject = xmlToJson.toJson()
        val gson = Gson()
        val gg = gson.fromJson<VSongs>(jsonObject.toString(), VSongs::class.java!!)


        for (parser in gg.songDB.song) {

            var song: Song = Song(title = parser.name, id = null)
            var id = repo.insert(song)

            var lyrics1: Lyrics = Lyrics(id = null, songs_id = id, language_id = 0, font = parser.font2, lyrics = parser.slide2)
            var lyrics2: Lyrics = Lyrics(id = null, songs_id = id, language_id = 1, font = parser.font, lyrics = parser.slide)

            repo.insert(lyrics1)
            repo.insert(lyrics2)

        }


//        for (i in 1..10) {
//            getSaltString(8)
//            var s: Song = Song(null, getSaltString(8), getSaltString(18), getSaltString(8), 1, true, false)
//            var id = db?.songsDao()?.insert(s)
//            for (j in 1..3) {
//                var l: Lyrics = Lyrics(null, i.toLong(), getSaltString(38), j.toLong(), "", "", j.toLong(), true)
//                db?.lyricsDao()?.insert(l)
//            }
//        }
    }

}
