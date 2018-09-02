package com.athul.letra.domain.database

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Relation
import com.athul.letra.domain.database.tables.Author
import com.athul.letra.domain.database.tables.Lyrics
import com.athul.letra.domain.database.tables.Song


class SongwithLyrics {

    @Embedded
    lateinit var song: Song

    @Relation(parentColumn = "index", entityColumn = "songs_id")
    var lyrics: List<Lyrics>? = null
    @Relation(parentColumn = "index", entityColumn = "songs_id")
    var author: List<Author>? = null


}