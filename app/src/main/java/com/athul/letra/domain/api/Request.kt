package com.athul.letra.domain.api

import com.athul.letra.domain.pojo.LetraResponse
import retrofit2.http.GET

import retrofit2.Call


interface Request {

    //https://raw.githubusercontent.com/athulcek/Letra/master/letra.json
    @GET("athulcek/Letra/master/letra.json")
    fun getSongs(): Call<LetraResponse>
}