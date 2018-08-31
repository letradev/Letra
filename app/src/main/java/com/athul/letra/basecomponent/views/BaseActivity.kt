package com.athul.letra.ui.basecomponent.views

import android.os.Bundle
import android.support.annotation.UiThread
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import athul.com.xsong.di.viewmodel.ViewModelComponent
import athul.com.xsong.di.viewmodel.ViewModelModule
import com.athul.letra.domain.database.AppDatabase
import com.athul.letra.application.LetraApp
import com.athul.letra.utils.DbWorkerThread

/**
 * Created by   developer on 10-04-2018.
 */
open class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private lateinit var mDbWorkerThread: DbWorkerThread
    @UiThread
    fun getViewModelComponent(): ViewModelComponent {
        return (application as LetraApp).getXApplicationComponent()
                .injectViewModelComponent(ViewModelModule(this))
    }

    open fun setToolbar(toolbar: Toolbar, title: String, isBackButtonRequired: Boolean) {
        setSupportActionBar(toolbar)

        if (supportActionBar != null) {
            supportActionBar!!.title = title
            supportActionBar!!.setDisplayHomeAsUpEnabled(isBackButtonRequired)

        }

    }

    open fun setToolbar(int: Int, title: String, isBackButtonRequired: Boolean) {
        val toolbar = findViewById(int) as Toolbar
        setSupportActionBar(toolbar)

        if (supportActionBar != null) {

            supportActionBar!!.title = title
            supportActionBar!!.setDisplayHomeAsUpEnabled(isBackButtonRequired)

        }

    }

    fun setToolbarTitle(title: String) {

        if (supportActionBar != null) {
            supportActionBar!!.title = title


        }

    }

    protected fun setToolbar(toolbar: Toolbar, title: String, drawable: Int) {
        setSupportActionBar(toolbar)

        if (supportActionBar != null) {

            supportActionBar!!.title = title
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setHomeAsUpIndicator(drawable)

        }

    }


    override fun onDestroy() {
        AppDatabase.destroyInstance()

        super.onDestroy()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {

            android.R.id.home -> {
                onBackPressed()
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }


    }

}