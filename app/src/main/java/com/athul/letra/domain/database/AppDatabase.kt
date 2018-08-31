package com.athul.letra.domain.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.athul.letra.domain.database.tables.Author
import com.athul.letra.domain.database.dao.AuthorDao
import com.athul.letra.domain.database.tables.Language
import com.athul.letra.domain.database.dao.LanguageDao
import com.athul.letra.domain.database.tables.Lyrics
import com.athul.letra.domain.database.dao.LyricsDao
import com.athul.letra.domain.database.tables.Song
import com.athul.letra.domain.database.dao.SongDao


/**
 *   on 11-04-2018.
 */
@Database(entities = [(Author::class),
    (Language::class),
    (Lyrics::class),
    (Song::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun authorDao(): AuthorDao

    abstract fun languagedao(): LanguageDao

    abstract fun lyricsDao(): LyricsDao

    abstract fun songsDao(): SongDao

    abstract fun CommonDao(): CommonDao


    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context?): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    context?.let {
                        INSTANCE = Room.databaseBuilder(it.getApplicationContext(),
                                AppDatabase::class.java, "xsong.db")
                                .build()
                    }
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}