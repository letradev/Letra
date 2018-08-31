package com.athul.letra.domain.pojo

data class Item(
	val song: List<SongItem?>? = null,
	val categoryId: List<String?>? = null,
	val author: Author? = null,
	val bibleReference: String? = null,
	val id: String? = null,
	val history: String? = null
)
