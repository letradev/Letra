package com.athul.letra.domain.parser;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by athulbabu on 15/11/16.
 */

@XStreamAlias("songDB")
public class SongDB {


    @SerializedName("song")
    @Expose
    private List<SongParser> song = new ArrayList<SongParser>();

    /**
     *
     * @return
     * The song
     */
    public List<SongParser> getSong() {
        return song;
    }

    /**
     *
     * @param song
     * The song
     */
    public void setSong(List<SongParser> song) {
        this.song = song;
    }
        }
