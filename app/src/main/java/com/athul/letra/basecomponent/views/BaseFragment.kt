package com.athul.letra.ui.basecomponent.views

import android.support.annotation.UiThread
import android.support.v4.app.Fragment
import athul.com.xsong.di.viewmodel.ViewModelComponent
import athul.com.xsong.di.viewmodel.ViewModelModule
import com.athul.letra.application.LetraApp

/**
 *  on 10-04-2018.
 */
open class BaseFragment : Fragment() {


    @UiThread
    fun getViewModelComponent(): ViewModelComponent {
        return (activity!!.application as LetraApp).getXApplicationComponent()
                .injectViewModelComponent(ViewModelModule(activity!!))
    }


}