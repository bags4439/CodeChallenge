package com.test.codechallenge.di

import com.google.gson.GsonBuilder
import com.test.codechallenge.BuildConfig
import com.test.codechallenge.data.source.remote.ApiService
import com.test.codechallenge.data.source.remote.LiveDataCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val retrofitModule = module {

    single { okHttp() }
    single { retrofit(get()) }
    single { retrofit(get()).create(ApiService::class.java) }
}

private fun retrofit(client: OkHttpClient): Retrofit {
    val gson = GsonBuilder()
        .create()

    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(LiveDataCallAdapterFactory())
        .build()
}
private val requestBodyLoggerInterceptor: Interceptor
    get() = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
        else HttpLoggingInterceptor.Level.NONE
    }

private val requestHeaderLoggerInterceptor: Interceptor
    get() = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.HEADERS
        else HttpLoggingInterceptor.Level.NONE
    }

private fun okHttp() = OkHttpClient.Builder()
    .addInterceptor(requestBodyLoggerInterceptor)
    .addInterceptor(requestHeaderLoggerInterceptor)
    .build()
