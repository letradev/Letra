package com.athul.letra.domain

import android.arch.lifecycle.LiveData
import com.athul.letra.domain.database.AppDatabase
import com.athul.letra.domain.database.tables.Lyrics
import com.athul.letra.domain.database.tables.Song
import retrofit2.Retrofit
import javax.inject.Inject


class Repo @Inject constructor(var appDatabase: AppDatabase) {

    fun getSongsLike(keyword: String): LiveData<List<Song>> {
        return appDatabase.songsDao().getSongs("%" + keyword + "%")
        // return appDatabase.songsDao().getAll()

    }

    fun getSongsStartswith(keyword: String): LiveData<List<Song>> {
        return appDatabase.songsDao().getSongs(keyword + "%")
        // return appDatabase.songsDao().getAll()

    }

    fun insert(song: Song): Long {
        return appDatabase.songsDao().insert(song)

    }

    fun insert(lyrics: Lyrics): Long {
        return appDatabase.lyricsDao().insert(lyrics)
    }

    fun getTotalCount(): Long {
        return appDatabase.songsDao().getAllCount()
    }


    fun fetchSong() {


    }


}