package com.athul.letra.features.ui.home.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.athul.letra.domain.Repo
import com.athul.letra.domain.database.tables.*
import com.athul.letra.domain.pojo.Response
import com.athul.letra.domain.repository.ApiResquest
import org.jetbrains.anko.doAsync
import javax.inject.Inject


class HomeViewModel
@Inject
constructor(private val repository: Repo, var apiResquest: ApiResquest) : ViewModel() {


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

    fun fetchSong() {
        doAsync {

            var re: Response? = apiResquest.getSong();
            re?.let {
                var author = it.db?.authors;
                var songs = it.db?.songs;
                var credits = it.db?.credits;


                songs?.song?.forEach {

                    it?.let {


                        var song: Song = Song(
                                index = it.id.toString().toLong(),
                                title = it.title.toString(),
                                aboutSong = it.aboutSong.toString(),
                                reference = it.bibleReference.toString(),
                                category_id = it.category.toString().toLong(),
                                author_id = it.author.toString().toLong(),
                                status = it.status.toString().toBoolean(),
                                notes = it.notes.toString(),
                                dateOfPublish = it.dateOfPublish.toString(),
                                createdDate = it.createdDate.toString(),
                                updatedDate = it.updatedDate.toString(),
                                credit_id = it.creditId.toString(),
                                tag = it.tag.toString(),
                                viewCount = it.viewCount.toString().toLong(),
                                isFav = false)
                        var song_id = repository.insert(song)



                        it.lyrics?.forEach {

                            it?.let {


                                var language: Language = Language(
                                        label = it.language.toString()
                                )

                                var language_id = repository.insert(language)

                                var lyrics: Lyrics = Lyrics(
                                        index = null,
                                        songs_id = song_id,
                                        lyric = it.lyric.toString(),
                                        language_id = language_id,
                                        font = it.font.toString(),
                                        translated_by = it.translatedBy.toString(),
                                        timeStamp = it.timeStamp.toString(),
                                        isOrginal = it.isOrginal.toString().toBoolean()
                                )
                                var lyrics_id = repository.insert(lyrics)
                                it.links?.forEach {

                                    it?.let {

                                        var link: Links = Links(
                                                index = null,
                                                lyricId = lyrics_id,
                                                url = it.url.toString(),
                                                timeStamp = it.timeStamp.toString()
                                        )
                                        repository.insert(link)
                                    }

                                }
                                it.keys?.forEach {

                                    it?.let {

                                        if (it.note.toString().length > 0) {
                                            var keys: Keys = Keys(
                                                    id = null,
                                                    lyric_id = lyrics_id,
                                                    notes = it.note.toString(),
                                                    instrument = it.instrument.toString()
                                            )
                                            repository.insert(keys)
                                        }

                                    }
                                }
                            }
                        }


                    }

                }

            }


        }

    }

    fun getKeyForLyricsId(index: Long?): Keys? {

        index?.let {
            return repository.getKeyForLyricsId(index)
        }



        return null;
    }


}