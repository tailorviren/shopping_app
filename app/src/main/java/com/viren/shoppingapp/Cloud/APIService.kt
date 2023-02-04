package com.viren.shoppingapp.Cloud

import com.viren.shoppingapp.model.GetProductItems
import com.viren.shoppingapp.model.UserProfile
import retrofit2.http.GET

interface APIService {

    @GET("bc09a745-4346-4025-9611-9da76366dbbc")
    suspend fun getProductList() : GetProductItems

    @GET("aaf97364-eedc-46a5-8f9e-56eb4b3cedd2")
    suspend fun userProfile(): UserProfile

}