package com.athul.letra.features.ui.lyrics.adaptor

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.athul.letra.R
import com.athul.letra.domain.database.tables.Song
import com.athul.letra.domain.pojo.LyricXml
import com.athul.letra.features.ui.search.adaptor.SearchAdaptor
import kotlinx.android.synthetic.main.row_lyric.view.*
import kotlinx.android.synthetic.main.row_search.view.*

class LyricsAdaptor(val items: LyricXml, val listener: (String) -> Unit) : RecyclerView.Adapter<LyricsAdaptor.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_lyric, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount() = items.getvers().size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(position, items.getvers()[position], listener)


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(position: Int, item: String, listener: (String) -> Unit) = with(itemView) {
            if (position % 2 == 0) {
                this.setBackgroundColor(Color.parseColor("#cccccc"))
            } else {
                this.setBackgroundColor(Color.parseColor("#ffffff"))

            }
            //lyric.setKeyLyric(lyric = item, key = null)
            lyric.text = item.replace("//br//","\n")
            //song_start_text.text = item.getvers()
            //search_text_in_song.text = item.title
            setOnClickListener { listener(item) }
        }
    }
}
