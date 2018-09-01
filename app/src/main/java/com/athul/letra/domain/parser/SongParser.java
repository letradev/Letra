package com.athul.letra.domain.parser;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("song")
public class SongParser
{
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("font")
    @Expose
    private String font;
    @SerializedName("font2")
    @Expose
    private String font2;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("yvideo")
    @Expose
    private String yvideo;
    @SerializedName("bkgnd")
    @Expose
    private String bkgnd;
    @SerializedName("slide")
    @Expose
    private String slide;
    @SerializedName("slide2")
    @Expose
    private String slide2;

    /**
     *
     * @return
     * The category
     */
    public String getCategory() {
        return category;
    }

    /**
     *
     * @param category
     * The category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The font
     */
    public String getFont() {
        return font;
    }

    /**
     *
     * @param font
     * The font
     */
    public void setFont(String font) {
        this.font = font;
    }

    /**
     *
     * @return
     * The font2
     */
    public String getFont2() {
        return font2;
    }

    /**
     *
     * @param font2
     * The font2
     */
    public void setFont2(String font2) {
        this.font2 = font2;
    }

    /**
     *
     * @return
     * The timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     *
     * @param timestamp
     * The timestamp
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     *
     * @return
     * The yvideo
     */
    public String getYvideo() {
        return yvideo;
    }

    /**
     *
     * @param yvideo
     * The yvideo
     */
    public void setYvideo(String yvideo) {
        this.yvideo = yvideo;
    }

    /**
     *
     * @return
     * The bkgnd
     */
    public String getBkgnd() {
        return bkgnd;
    }

    /**
     *
     * @param bkgnd
     * The bkgnd
     */
    public void setBkgnd(String bkgnd) {
        this.bkgnd = bkgnd;
    }

    /**
     *
     * @return
     * The slide
     */
    public String getSlide() {
        return slide;
    }

    /**
     *
     * @param slide
     * The slide
     */
    public void setSlide(String slide) {
        this.slide = slide;
    }

    /**
     *
     * @return
     * The slide2
     */
    public String getSlide2() {
        return slide2;
    }

    /**
     *
     * @param slide2
     * The slide2
     */
    public void setSlide2(String slide2) {
        this.slide2 = slide2;
    }
}