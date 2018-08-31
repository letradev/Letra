package com.athul.letra.features.ui.song

import android.os.Bundle
import android.support.design.widget.Snackbar
import com.athul.letra.R
import com.athul.letra.application.AppConstants
import com.athul.letra.domain.database.AppDatabase
import com.athul.letra.features.ui.song.view.SongFragment
import com.athul.letra.ui.basecomponent.views.BaseActivity
import com.athul.letra.utils.ext.addFragment
import com.athul.letra.utils.ext.replaceFragment
import com.athul.letra.utils.ext.toastLong

import kotlinx.android.synthetic.main.activity_song.*
import javax.inject.Inject

class SongActivity : BaseActivity() {

    @Inject
    lateinit var appDatabase: AppDatabase

    private lateinit var songFragment: SongFragment

    private var id: Long = -1;

    override fun onCreate(savedInstanceState: Bundle?) {
        getViewModelComponent().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song)
        setToolbar(toolbar, "", true)
        id = intent.extras.getLong(AppConstants.SONG_ID)
        toastLong("id" + id)
        setupFragments()
        replaceFragment(songFragment, R.id.fragment)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    private fun setupFragments() {
        songFragment = SongFragment.newInstance(id)

        addFragment(songFragment, R.id.fragment);


    }
}
