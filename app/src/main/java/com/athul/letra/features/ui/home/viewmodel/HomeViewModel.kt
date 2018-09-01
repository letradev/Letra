package com.athul.letra.features.ui.home.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.athul.letra.domain.Repo
import com.athul.letra.domain.database.tables.Lyrics
import com.athul.letra.domain.database.tables.Song
import com.athul.letra.domain.pojo.Response
import com.athul.letra.domain.repository.ApiResquest
import org.jetbrains.anko.doAsync
import javax.inject.Inject


class HomeViewModel
@Inject
constructor(private val repository: Repo, var apiResquest: ApiResquest) : ViewModel() {


    fun getSongsLike(keyword: String): LiveData<List<Song>>? {

        return repository.getSongsLike(keyword);


    }

    fun getSongsByKeyword(keyword: String): LiveData<List<Song>>? {

        val s = repository.getSongsStartswith(keyword);

        if (s == null) {
            return repository.getSongsLike(keyword);
        } else {
            return s;
        }


    }

    fun fetchSong() {
        doAsync {

            var re: Response? = apiResquest.getSong();
            re?.let {
                var author = it.db?.authors;
                var songs = it.db?.songs;
                var credits = it.db?.credits;


                songs?.song?.forEach {

                   // var lyrics1: Lyrics = Lyrics(id = null, songs_id = it?.id!!.toLong(), language_id = 0, font = parser.font2, lyrics = parser.slide2)

                }


            }

        }

    }

}