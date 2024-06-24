package com.example.androidtestsample.api

import retrofit2.Response
import retrofit2.http.GET


interface ShoppApi {

    @GET("posts")
    suspend fun getUser(): Response<List<UserNetworkResponse>>

}