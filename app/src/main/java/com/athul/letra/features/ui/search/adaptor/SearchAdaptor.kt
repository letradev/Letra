package com.athul.letra.features.ui.search.adaptor

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.athul.letra.R
import com.athul.letra.domain.database.tables.Song
import kotlinx.android.synthetic.main.row_search.view.*

/**
 * Created by zco developer on 19-04-2018.
 */

class SearchAdaptor(val items: List<Song>, val listener: (Song) -> Unit) : Adapter<SearchAdaptor.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row_search, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(position, items[position], listener)


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(position: Int, item: Song, listener: (Song) -> Unit) = with(itemView) {
            if (position % 2 == 0) {
                this.setBackgroundColor(Color.parseColor("#cccccc"))
            } else {
                this.setBackgroundColor(Color.parseColor("#ffffff"))

            }
            song_start_text.text = item.title
            search_text_in_song.text = item.title
            setOnClickListener { listener(item) }
        }
    }
}
