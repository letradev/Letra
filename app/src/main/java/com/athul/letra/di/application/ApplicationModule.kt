package com.athul.letra.di.application

import android.app.Application
import android.arch.persistence.room.Room
import athul.com.xsong.di.viewmodel.ViewModelBuilder
import com.athul.letra.application.LetraApp
import com.athul.letra.di.UtilityModule
import com.athul.letra.domain.Repo
import com.athul.letra.domain.database.AppDatabase
import dagger.Module
import dagger.Provides


@Module(includes = arrayOf(ViewModelBuilder::class
        , UtilityModule::class))
open class ApplicationModule constructor(private val xApplication: LetraApp) {


    @Provides
    @ApplicationScope
    fun application(): Application = xApplication

    @Provides
    @ApplicationScope
    fun provideRepo(appDatabase: AppDatabase): Repo {
        return Repo(appDatabase)
    }

    @ApplicationScope
    @Provides
    fun provideDb(app: Application): AppDatabase {
        return Room.databaseBuilder(app, AppDatabase::class.java!!, "xsong.db").build()
    }


}