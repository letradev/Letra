package com.athul.letra.domain.database.tables

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Language")
data class Language(

        @Expose
        @PrimaryKey
        var id: Long,

        @Expose
        @SerializedName("language_id")
        @ColumnInfo(name = "language_id")
        var language_id: Long,

        @Expose
        @SerializedName("label")
        @ColumnInfo(name = "label")
        var label: String
)