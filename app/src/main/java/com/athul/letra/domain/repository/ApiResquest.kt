package com.athul.letra.domain.repository

import com.athul.letra.domain.api.Request
import com.athul.letra.domain.pojo.Response
import retrofit2.Retrofit
import javax.inject.Inject

class ApiResquest {

    val retrofit: Retrofit

    @Inject
    constructor(retrofit: Retrofit) {

        this.retrofit = retrofit
    }

    fun getSong(): Response? {
        var request: Request = retrofit.create(Request::class.java)
        return request.getSongs().execute().body()

    }
}