package com.athul.letra.application

import android.app.Application
import com.athul.letra.domain.parser.SongDB
import com.athul.letra.domain.parser.VSongs
import com.athul.letra.di.application.ApplicationComponent
import com.athul.letra.di.application.ApplicationModule
import com.athul.letra.di.application.DaggerApplicationComponent

import timber.log.Timber
import javax.inject.Inject


/**
 * Created by  developer on 10-04-2018.import com.athul.letra.di.application.DaggerApplicationComponent
 */
class LetraApp : Application() {

    @Inject
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        getXApplicationComponent().inject(this)
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }


    fun getXApplicationComponent(): ApplicationComponent {

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule((this)))
                .build()

        return applicationComponent
    }


}