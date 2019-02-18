package com.athul.letra.domain.database.tables

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
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
        var notes: String = "",

        @SerializedName("instrument")
        @ColumnInfo(name = "instrument")
        var instrument: String = ""

) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readValue(Long::class.java.classLoader) as? Long,
            parcel.readLong(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeLong(lyric_id)
        parcel.writeString(notes)
        parcel.writeString(instrument)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Keys> {
        override fun createFromParcel(parcel: Parcel): Keys {
            return Keys(parcel)
        }

        override fun newArray(size: Int): Array<Keys?> {
            return arrayOfNulls(size)
        }
    }
}