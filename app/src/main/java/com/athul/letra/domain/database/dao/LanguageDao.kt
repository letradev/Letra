package com.athul.letra.domain.database.dao
import android.arch.persistence.room.Dao
import com.athul.letra.domain.database.BaseDao
import com.athul.letra.domain.database.tables.Lyrics

/**
 * Created by athulbabu on 25/03/18.
 */
@Dao
interface LanguageDao  : BaseDao<Lyrics> {
}