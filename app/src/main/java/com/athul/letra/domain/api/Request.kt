package com.athul.letra.domain.api

import com.athul.letra.domain.pojo.Response
import retrofit2.http.GET

import retrofit2.Call


interface Request {

    //https://raw.githubusercontent.com/letradev/Letra/master/song.json
    @GET("letradev/Letra/master/song.json")
    fun getSongs(): Call<Response>
}