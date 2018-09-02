package com.athul.letra.domain.database.tables

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "Keys")
data class Keys(
        @PrimaryKey(autoGenerate = true)
        var id: Long?,

        @SerializedName("lyric_id")
        @ColumnInfo(name = "lyric_id")
        var lyric_id: Long = 0,

        @SerializedName("notes")
        @ColumnInfo(name = "notes")
        var notes: String="",

        @SerializedName("instrument")
        @ColumnInfo(name = "instrument")
        var instrument: String=""

) {
}