package com.athul.letra.domain.pojo


import com.google.gson.annotations.SerializedName

data class Db(

	@field:SerializedName("credits")
	val credits: Credits? = null,

	@field:SerializedName("songs")
	val songs: Songs? = null,

	@field:SerializedName("authors")
	val authors: Authors? = null
)