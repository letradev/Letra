package com.athul.letra.domain.pojo


import com.google.gson.annotations.SerializedName


data class CreditItem(

	@field:SerializedName("notes")
	val notes: String? = null,

	@field:SerializedName("social")
	val social: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)