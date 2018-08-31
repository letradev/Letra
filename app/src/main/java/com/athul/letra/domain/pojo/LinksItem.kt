package com.athul.letra.domain.pojo


import com.google.gson.annotations.SerializedName


data class LinksItem(

	@field:SerializedName("time_stamp")
	val timeStamp: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)