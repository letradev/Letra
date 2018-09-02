package com.athul.letra.features.ui.home

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
import com.athul.letra.databinding.ActivityHomeBinding
import com.athul.letra.domain.database.AppDatabase
import com.athul.letra.features.ui.home.viewmodel.HomeViewModel
import com.athul.letra.features.ui.newauthor.view.NewAuthor
import com.athul.letra.features.ui.search.view.SearchFragment
import com.athul.letra.features.ui.song.view.FavouriteSong
import com.athul.letra.features.ui.song.view.NewSongFragment
import com.athul.letra.ui.basecomponent.views.BaseActivity
import com.athul.letra.utils.ext.addFragment
import com.athul.letra.utils.ext.replaceFragment
import com.athul.letra.utils.ext.setfullscreen
import com.athul.letra.utils.ext.toastLong
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.content_home.*
import javax.inject.Inject

class HomeActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var appDatabase: AppDatabase

    lateinit var viewModel: HomeViewModel


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


        viewModel.fetchSong();



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


}
