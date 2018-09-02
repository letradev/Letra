package com.athul.letra.domain.database.tables


import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "Links", indices = arrayOf(Index(value = "url", unique = true)))
data class Links(


        @PrimaryKey(autoGenerate = true)
        var index: Long?,


        @SerializedName("timeStamp")
        @ColumnInfo(name = "timeStamp")
        var timeStamp: String = "",

        @SerializedName("lyricId")
        @ColumnInfo(name = "lyricId")
        var lyricId: Long = 0,

        @SerializedName("url")
        @ColumnInfo(name = "url")
        var url: String = ""
)