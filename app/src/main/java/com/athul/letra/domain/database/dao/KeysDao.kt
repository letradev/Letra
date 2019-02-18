package com.athul.letra.domain.database.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.athul.letra.domain.database.BaseDao
import com.athul.letra.domain.database.tables.Keys
import com.athul.letra.domain.database.tables.Lyrics
import com.athul.letra.domain.database.tables.Song

@Dao
interface KeysDao : BaseDao<Keys> {


    @Query("SELECT * FROM Keys where lyric_id=:index")
    fun getKeyForLyricsId(index: Long): Keys


}