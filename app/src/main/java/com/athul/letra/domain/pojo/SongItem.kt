package com.athul.letra.domain.pojo


import com.google.gson.annotations.SerializedName


data class SongItem(

	@field:SerializedName("notes")
	val notes: String? = null,

	@field:SerializedName("author")
	val author: String? = null,

	@field:SerializedName("aboutSong")
	val aboutSong: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("date_of_publish")
	val dateOfPublish: String? = null,

	@field:SerializedName("credit_id")
	val creditId: List<String?>? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("tag")
	val tag: String? = null,

	@field:SerializedName("updated_date")
	val updatedDate: String? = null,

	@field:SerializedName("created_date")
	val createdDate: String? = null,

	@field:SerializedName("category")
	val category: String? = null,

	@field:SerializedName("lyrics")
	val lyrics: List<LyricsItem?>? = null,

	@field:SerializedName("view_count")
	val viewCount: String? = null,

	@field:SerializedName("bibleReference")
	val bibleReference: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)