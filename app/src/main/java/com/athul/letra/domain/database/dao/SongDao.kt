package com.athul.letra.domain.database.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.athul.letra.domain.database.BaseDao
import com.athul.letra.domain.database.tables.Song

@Dao
interface SongDao : BaseDao<Song> {


    @Query("SELECT * FROM Songs where title LIKE :keyword")
    fun getSongs(keyword: String): LiveData<List<Song>>


    @Query("SELECT * FROM Songs")
    fun getAll(): LiveData<List<Song>>


    @Query("select count(*) from Songs")
    fun getAllCount(): Long
}