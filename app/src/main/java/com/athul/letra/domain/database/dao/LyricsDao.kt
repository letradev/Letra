package com.athul.letra.domain.database.dao

import android.arch.persistence.room.Dao
import com.athul.letra.domain.database.BaseDao
import com.athul.letra.domain.database.tables.Lyrics

/**
 * Created by zco developer on 11-04-2018.
 */
@Dao
interface LyricsDao : BaseDao<Lyrics> {

}