package com.athul.letra.domain.database.tables

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "Keys")
data  class Keys(
        @PrimaryKey(autoGenerate = true)
        var id: Long?,

        @SerializedName("title")
        @ColumnInfo(name = "title")
        var title: String

        ) {
}