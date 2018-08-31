package com.athul.letra.domain.database

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Relation
import com.athul.letra.domain.database.tables.Author
import com.athul.letra.domain.database.tables.Lyrics
import com.athul.letra.domain.database.tables.Song


/**
 * Created by   on 18-04-2018.
 */
class SongwithLyrics {

    @Embedded
    lateinit var song: Song

    @Relation(parentColumn = "id", entityColumn = "songs_id")
    var lyrics: List<Lyrics>? = null
    @Relation(parentColumn = "id", entityColumn = "songs_id")
    var author: List<Author>? = null


}