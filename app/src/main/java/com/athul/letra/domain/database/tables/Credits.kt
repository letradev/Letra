package com.athul.letra.domain.database.tables

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "Credits")
data class Credits(


        @PrimaryKey(autoGenerate = true)
        var index: Long,

        @SerializedName("id")
        @ColumnInfo(name = "id")
        var id: Long = 0,

        @SerializedName("notes")
        @ColumnInfo(name = "notes")
        val notes: String = "",

        @SerializedName("social")
        @ColumnInfo(name = "social")
        val social: String = "",

        @SerializedName("name")
        @ColumnInfo(name = "name")
        val name: String = "",

        @SerializedName("email")
        @ColumnInfo(name = "email")
        val email: String = ""
)