package com.athul.letra.features.ui.song.adaptor

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.athul.letra.R
import com.github.nitrico.fontbinder.FontBinder

class LyricsAdaptor(val songs: List<String>, val font: String) : RecyclerView.Adapter<LyricsAdaptor.SongsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LyricsAdaptor.SongsViewHolder {
        val v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_lyrics_item, parent, false)
        return SongsViewHolder(v)
    }

    override fun getItemCount() = songs.size


    override fun onBindViewHolder(holder: LyricsAdaptor.SongsViewHolder, position: Int) {
        val song = songs[position].replace("<BR>", "\n")
        holder.meaning.text = song
        holder.meaning.typeface = FontBinder[font]

    }

    class SongsViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var cv: CardView
        internal var meaning: TextView


        init {
            cv = itemView.findViewById<View>(R.id.cv) as CardView
            meaning = itemView.findViewById<View>(R.id.tv_lyrics) as TextView
            meaning.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
        }
    }

}