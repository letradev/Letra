package com.athul.letra.domain.pojo


import com.google.gson.annotations.SerializedName


data class Songs(

	@field:SerializedName("song")
	val song: List<SongItem?>? = null
)