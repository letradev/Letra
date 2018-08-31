package com.athul.letra.domain.pojo


import com.google.gson.annotations.SerializedName


data class Response(

	@field:SerializedName("db")
	val db: Db? = null
)