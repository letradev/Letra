package com.athul.letra.domain.database.tables

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName


/**
 * Created by athulbabu on 25/03/18.
 */


@Entity(tableName = "Songs")
data class Song(


        @PrimaryKey(autoGenerate = true)
        var id: Long?,


        @SerializedName("title")
        @ColumnInfo(name = "title")
        var title: String,


        @SerializedName("history")
        @ColumnInfo(name = "history")
        var history: String = "",


        @SerializedName("reference")
        @ColumnInfo(name = "reference")
        var reference: String = "",


        @SerializedName("category_id")
        @ColumnInfo(name = "category_id")
        var category_id: Long = 0,


        @SerializedName("status")
        @ColumnInfo(name = "status")
        var status: Boolean = false,


        @SerializedName("isFav")
        @ColumnInfo(name = "isFav")
        var isFav: Boolean = false




)