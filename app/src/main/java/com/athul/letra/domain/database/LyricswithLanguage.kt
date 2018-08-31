package com.athul.letra.domain.database

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Relation
import com.athul.letra.domain.database.tables.Language
import com.athul.letra.domain.database.tables.Lyrics


/**
 * Created by  on 18-04-2018.
 */
class LyricswithLanguage {

    @Embedded
    lateinit var lyrics: Lyrics

    @Relation(parentColumn = "language_id", entityColumn = "id")
    var language: List<Language>? = null
}