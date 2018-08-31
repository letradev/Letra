package com.athul.letra.features.ui.home.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.athul.letra.domain.Repo
import com.athul.letra.domain.database.tables.Song
import javax.inject.Inject


class HomeViewModel
@Inject
constructor(private val repository: Repo) : ViewModel() {


    fun getSongsLike(keyword: String): LiveData<List<Song>>? {

        return repository.getSongsLike(keyword);


    }

    fun getSongsByKeyword(keyword: String): LiveData<List<Song>>? {

        val s = repository.getSongsStartswith(keyword);

        if (s == null) {
            return repository.getSongsLike(keyword);
        } else {
            return s;
        }


    }

}