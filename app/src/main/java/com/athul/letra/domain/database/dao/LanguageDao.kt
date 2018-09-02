package com.athul.letra.domain.database.dao

import android.arch.persistence.room.Dao
import com.athul.letra.domain.database.BaseDao
import com.athul.letra.domain.database.tables.Language
import com.athul.letra.domain.database.tables.Lyrics

/**
 * Created by athulbabu on 25/03/18.
 */
@Dao
abstract class LanguageDao : BaseDao<Language> {


   /* fun upsert(language: Language): Long {

        var id: Long = insert(language);

        if (id.equals(-1)) {
            update(language)
        }
    }*/


}