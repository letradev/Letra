package com.athul.letra.domain.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface CommonDao {

    @Query("SELECT * FROM songs WHERE `index` = :id")
    fun getSongs(id: Long): SongwithLyrics


}