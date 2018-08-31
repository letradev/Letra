package com.athul.letra.domain.pojo


import com.google.gson.annotations.SerializedName


data class KeysItem(

	@field:SerializedName("note")
	val note: String? = null,

	@field:SerializedName("instrument")
	val instrument: String? = null
)