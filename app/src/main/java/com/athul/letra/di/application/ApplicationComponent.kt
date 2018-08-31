package com.athul.letra.di.application

import athul.com.xsong.di.viewmodel.ViewModelComponent
import athul.com.xsong.di.viewmodel.ViewModelModule
import com.athul.letra.application.LetraApp
import com.athul.letra.di.UtilityModule
import dagger.Component

@ApplicationScope
@Component(
        modules = arrayOf(
                UtilityModule::class,
                ApplicationModule::class,
                SettingsModule::class
        )
)
interface ApplicationComponent {


    fun inject(xApplication: LetraApp)

    fun injectViewModelComponent(viewModelModule: ViewModelModule): ViewModelComponent

}