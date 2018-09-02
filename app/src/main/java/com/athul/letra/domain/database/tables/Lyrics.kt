package com.athul.letra.domain.database.tables

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by athulbabu on 25/03/18.
 */

@Entity(tableName = "Lyrics", foreignKeys = [(ForeignKey(entity = Song::class,
        parentColumns = arrayOf("index"),
        childColumns = arrayOf("songs_id"),
        onDelete = ForeignKey.CASCADE))])

data class Lyrics
(
        @Expose
        @PrimaryKey(autoGenerate = true)
        var index: Long?,

        @Expose
        @SerializedName("songs_id")
        @ColumnInfo(name = "songs_id")
        var songs_id: Long,


        @Expose
        @SerializedName("lyric")
        @ColumnInfo(name = "lyric")
        var lyric: String,

        @Expose
        @SerializedName("language_id")
        @ColumnInfo(name = "language_id")
        var language_id: Long,


        @Expose
        @SerializedName("font")
        @ColumnInfo(name = "font")
        var font: String = "",

        @Expose
        @SerializedName("translated_by")
        @ColumnInfo(name = "translated_by")
        var translated_by: String = "",

        @Expose
        @SerializedName("timeStamp")
        @ColumnInfo(name = "timeStamp")
        var timeStamp: String = "",


        @Expose
        @SerializedName("isOrginal")
        @ColumnInfo(name = "isOrginal")
        var isOrginal: Boolean = false


) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readValue(Long::class.java.classLoader) as? Long,
            parcel.readLong(),
            parcel.readString(),
            parcel.readLong(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readByte() != 0.toByte()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(index)
        parcel.writeLong(songs_id)
        parcel.writeString(lyric)
        parcel.writeLong(language_id)
        parcel.writeString(font)
        parcel.writeString(translated_by)
        parcel.writeString(timeStamp)
        parcel.writeByte(if (isOrginal) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Lyrics> {
        override fun createFromParcel(parcel: Parcel): Lyrics {
            return Lyrics(parcel)
        }

        override fun newArray(size: Int): Array<Lyrics?> {
            return arrayOfNulls(size)
        }
    }
}

