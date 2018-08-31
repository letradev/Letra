package com.athul.letra.domain.pojo


import com.google.gson.annotations.SerializedName


data class LyricsItem(

	@field:SerializedName("isOrginal")
	val isOrginal: String? = null,

	@field:SerializedName("time_stamp")
	val timeStamp: String? = null,

	@field:SerializedName("lyric")
	val lyric: String? = null,

	@field:SerializedName("keys")
	val keys: List<KeysItem?>? = null,

	@field:SerializedName("language")
	val language: String? = null,

	@field:SerializedName("translated_by")
	val translatedBy: String? = null,

	@field:SerializedName("links")
	val links: List<LinksItem?>? = null,

	@field:SerializedName("font")
	val font: String? = null
)