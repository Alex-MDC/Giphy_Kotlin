package com.delnortedevs.giphykotlin

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface GiphyInterface {

    @GET("v1/gifs/search?")
    fun getGiphys(@QueryMap params: Map<String, String>) : Call<GiphyResponse>

    companion object {

        private val logger  = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        var BASE_URL = "https://api.giphy.com/"

        fun create() : GiphyInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(okhttpClient())
                .build()
            return retrofit.create(GiphyInterface::class.java)

        }

        private fun okhttpClient(): OkHttpClient {
            return OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

        }



    }

}