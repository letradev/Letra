package com.athul.letra.domain.pojo

data class SongItem(
	val isOrginal: String? = null,
	val notes: String? = null,
	val language: Language? = null,
	val isFav: String? = null,
	val lyrics: String? = null,
	val url: List<String?>? = null,
	val font: String? = null,
	val status: String? = null
)
