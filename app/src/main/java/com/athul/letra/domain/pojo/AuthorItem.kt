package com.athul.letra.domain.pojo


import com.google.gson.annotations.SerializedName


data class AuthorItem(

	@field:SerializedName("notes")
	val notes: String? = null,

	@field:SerializedName("dob")
	val dob: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("dod")
	val dod: String? = null,

	@field:SerializedName("about")
	val about: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("place")
	val place: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)