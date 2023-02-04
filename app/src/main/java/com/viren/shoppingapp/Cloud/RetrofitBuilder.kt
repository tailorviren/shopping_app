package com.viren.shoppingapp.Cloud

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {

    //private const val BASEURL = "https://reqres.in/"

    object RetrofitBuilder {

        fun getRetrofit() : Retrofit{
            return Retrofit.Builder()
                .baseUrl("https://run.mocky.io/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

    }

    //val apiService : APIService = getRetrofit().create(APIService::class.java)

}