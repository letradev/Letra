package com.athul.letra.domain.database.tables

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "Songs", indices = arrayOf(Index(value = "title", unique = true)))
data class Song(


        @PrimaryKey(autoGenerate = true)
        var index: Long?,


        @SerializedName("title")
        @ColumnInfo(name = "title")
        var title: String = "",


        @SerializedName("aboutSong")
        @ColumnInfo(name = "aboutSong")
        var aboutSong: String = "",


        @SerializedName("reference")
        @ColumnInfo(name = "reference")
        var reference: String = "",


        @SerializedName("category_id")
        @ColumnInfo(name = "category_id")
        var category_id: Long = 0,

        @SerializedName("author_id")
        @ColumnInfo(name = "author_id")
        var author_id: Long = 0,


        @SerializedName("status")
        @ColumnInfo(name = "status")
        var status: Boolean = false,

        @SerializedName("notes")
        @ColumnInfo(name = "notes")
        var notes: String = "",

        @SerializedName("dateOfPublish")
        @ColumnInfo(name = "dateOfPublish")
        var dateOfPublish: String = "",

        @SerializedName("updatedDate")
        @ColumnInfo(name = "updatedDate")
        var updatedDate: String = "",

        @SerializedName("createdDate")
        @ColumnInfo(name = "createdDate")
        var createdDate: String = "",

        @SerializedName("credit_id")
        @ColumnInfo(name = "credit_id")
        var credit_id: String = "",

        @SerializedName("tag")
        @ColumnInfo(name = "tag")
        var tag: String = "",

        @SerializedName("viewCount")
        @ColumnInfo(name = "viewCount")
        var viewCount: Long = 0,


        @SerializedName("isFav")
        @ColumnInfo(name = "isFav")
        var isFav: Boolean = false


)