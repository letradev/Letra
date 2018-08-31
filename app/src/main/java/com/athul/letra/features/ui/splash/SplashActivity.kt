package com.athul.letra.ui.splash

import android.os.Bundle
import com.athul.letra.MainActivity
import com.athul.letra.R
import com.athul.letra.features.ui.home.HomeActivity
import com.athul.letra.ui.basecomponent.views.BaseActivity
import com.athul.letra.utils.ext.moveToActivity

/**
 * Created by  developer on 11-04-2018.
 */
class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        moveToActivity(HomeActivity::class.java, true)
    }
}