package com.example.myappapi
import data.models.NewsResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

object RetrofitClient {

    private const val BASE_URL = "https://newsapi.org/"
    private var retrofit: Retrofit? = null

    fun getClient(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }

}
object Retrofit {


        val retrofitService: RetrofitServices
            get() = RetrofitClient.getClient().create(RetrofitServices::class.java)

}

interface RetrofitServices {

    @GET("v2/top-headlines?country=ua")
    suspend fun getNewsList(@Query("apiKey") apiKey: String): NewsResponse

}