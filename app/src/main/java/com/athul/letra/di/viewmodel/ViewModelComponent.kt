package athul.com.xsong.di.viewmodel

import com.athul.letra.di.UtilityModule
import com.athul.letra.features.ui.home.HomeActivity
import com.athul.letra.features.ui.home.view.HomeFragment
import com.athul.letra.features.ui.newauthor.view.NewAuthor
import com.athul.letra.features.ui.search.view.LyricsFragment
import com.athul.letra.features.ui.song.view.FavouriteSong
import com.athul.letra.features.ui.song.view.NewSongFragment
import com.athul.letra.features.ui.search.view.SearchFragment
import com.athul.letra.features.ui.search.view.YoutubeFragment
import com.athul.letra.features.ui.song.SongActivity
import com.athul.letra.features.ui.song.view.SongFragment
import dagger.Subcomponent



@Subcomponent(
        modules = arrayOf(
                ViewModelModule::class
        )
)
interface ViewModelComponent {

    //activity
    fun inject(activity: HomeActivity)

    fun inject(activity: SongActivity)


    //fragment
    fun inject(fragment: HomeFragment)

    fun inject(fragment: SearchFragment)
    fun inject(fragment: NewSongFragment)
    fun inject(fragment: NewAuthor)
    fun inject(fragment: FavouriteSong)
    fun inject(fragment: YoutubeFragment)
    fun inject(fragment: LyricsFragment)
    fun inject(fragment: SongFragment)

}