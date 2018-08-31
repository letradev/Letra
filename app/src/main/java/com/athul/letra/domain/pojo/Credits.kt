package com.athul.letra.domain.pojo


import com.google.gson.annotations.SerializedName


data class Credits(

        @field:SerializedName("credit")
        val credit: List<CreditItem?>? = null
)