package com.athul.letra.domain.repository

import com.athul.letra.domain.api.Request
import retrofit2.Retrofit
import javax.inject.Inject

class ApiResquest {

    val retrofit: Retrofit

    @Inject
    constructor(retrofit: Retrofit) {

        this.retrofit = retrofit
    }

    fun getSong() {
        var request: Request = retrofit.create(Request::class.java)
        var result = request.getSongs().execute().body()
        print(result)

    }
}