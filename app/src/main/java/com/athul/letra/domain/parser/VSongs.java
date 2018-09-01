package com.athul.letra.domain.parser;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;




public class VSongs
{

    @SerializedName("songDB")
    @Expose
    private SongDB songDB;

    /**
     *
     * @return
     * The songDB
     */
    public SongDB getSongDB() {
        return songDB;
    }

    /**
     *
     * @param songDB
     * The songDB
     */
    public void setSongDB(SongDB songDB) {
        this.songDB = songDB;
    }
}
