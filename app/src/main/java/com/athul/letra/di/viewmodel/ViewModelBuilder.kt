package athul.com.xsong.di.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.athul.letra.features.ui.home.viewmodel.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindSplashViewModel(splashViewModel: HomeViewModel): ViewModel


    @Binds
    abstract fun bindViewModelFactory(kotlinViewModelFactory: ViewModelFactory): ViewModelProvider.Factory

}