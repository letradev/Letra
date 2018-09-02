package com.athul.letra.domain.database.tables

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull


@Entity(tableName = "Language", indices = arrayOf(Index(value = "label", unique = true)))
data class Language(

        @Expose
        @PrimaryKey(autoGenerate = true)
        var index: Long = 0,

        @NotNull
        @Expose
        @SerializedName("label")
        @ColumnInfo(name = "label")
        var label: String
)