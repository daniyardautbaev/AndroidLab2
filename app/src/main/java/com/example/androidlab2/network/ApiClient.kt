package com.example.androidlab2.network


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private val okHttpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request()

                val newRequest = request.newBuilder()
                        .addHeader("X-Api-Key", "dqSALaLAfohSTfGopi4hLQ==IABNEAlwcpcwZSA3")
                        .build()
                chain.proceed(newRequest)
            }
            .addInterceptor(
                    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .build()

    private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.api-ninjas.com/v1/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val instance = retrofit.create(ApiService::class.java)


}
