package com.athul.letra.domain.database.tables

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import com.google.gson.annotations.Expose
import android.arch.persistence.room.PrimaryKey

import com.google.gson.annotations.SerializedName
import android.arch.persistence.room.ColumnInfo

/**
 * Created by zco developer on 11-04-2018.
 */
@Entity(tableName = "Author", foreignKeys = [(ForeignKey(entity = Song::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("songs_id"),
        onDelete = ForeignKey.CASCADE))])
data class Author(

        @Expose
        @PrimaryKey
        var id: Long,

        @Expose
        @SerializedName("songs_id")
        @ColumnInfo(name = "songs_id")
        var songs_id: Long,

        @Expose
        @SerializedName("name")
        @ColumnInfo(name = "name")
        var name: String,

        @Expose
        @SerializedName("dob")
        @ColumnInfo(name = "dob")
        var dob: String?,

        @Expose
        @SerializedName("dod")
        @ColumnInfo(name = "dod")
        var dod: String?,

        @Expose
        @SerializedName("about")
        @ColumnInfo(name = "about")
        var about: String?,

        @Expose
        @SerializedName("nick_name")
        @ColumnInfo(name = "nick_name")
        var nick_name: String?

)