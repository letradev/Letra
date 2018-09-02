package com.athul.letra.domain

import android.arch.lifecycle.LiveData
import com.athul.letra.domain.database.AppDatabase
import com.athul.letra.domain.database.tables.*
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

    fun insert(language: Language): Long {
        return appDatabase.languagedao().insert(language)

    }

    fun insert(lyrics: Lyrics): Long {
        return appDatabase.lyricsDao().insert(lyrics)
    }

    fun insert(keys: Keys): Long {
        return appDatabase.keysDao().insert(keys)
    }


    fun insert(links: Links): Long {
        return appDatabase.linksDao().insert(links)
    }


    fun getTotalCount(): Long {
        return appDatabase.songsDao().getAllCount()
    }


    fun fetchSong() {


    }


}