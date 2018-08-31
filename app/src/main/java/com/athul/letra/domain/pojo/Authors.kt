package com.athul.letra.domain.pojo


import com.google.gson.annotations.SerializedName


data class Authors(

	@field:SerializedName("author")
	val author: List<AuthorItem?>? = null
)