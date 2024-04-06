package com.example.androidlab2.network

import com.example.androidlab2.model.Celebrity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("celebrity")
    fun fetchCelebrity(@Query("name") name: String? = null, @Query("gender") gender : String? = null ): Call<List<Celebrity>>

}