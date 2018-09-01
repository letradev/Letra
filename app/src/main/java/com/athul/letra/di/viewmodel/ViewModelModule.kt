package athul.com.xsong.di.viewmodel

import android.app.Activity
import android.content.Context
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.athul.letra.ui.basecomponent.factories.DialogsFactory
import com.athul.letra.ui.basecomponent.managers.DialogsManager
import dagger.Module
import dagger.Provides


@Module
class ViewModelModule
constructor(private val activity: FragmentActivity) {


    @Provides
    fun provideContext(): Context = activity


    @Provides
    fun provideActivity(): Activity = activity

    @Provides
    fun provideFragmentManager(): FragmentManager = activity.supportFragmentManager

    @Provides
    fun provideDialogManager(fragmentManager: FragmentManager) = DialogsManager(fragmentManager)

    @Provides
    fun provideDialogFactory(): DialogsFactory = DialogsFactory()




}