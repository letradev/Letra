package com.athul.letra.di

import android.app.Application
import athul.com.xsong.di.viewmodel.ViewModelBuilder
import com.athul.letra.application.AppConstants
import com.athul.letra.application.LetraApp
import com.athul.letra.di.application.ApplicationScope
import com.athul.letra.domain.repository.ApiResquest
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

@Module
open class UtilityModule constructor() {


    @Provides
    @ApplicationScope
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {

        return Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
    }

    @Provides
    @ApplicationScope
    fun provideGson(): Gson {
        return GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create()
    }

    @Provides
    @ApplicationScope
    fun provideokhttp(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
    }


    @Provides
    @ApplicationScope
    fun provideApiResquest(retrofit: Retrofit): ApiResquest {

        return ApiResquest(retrofit)
    }


}
