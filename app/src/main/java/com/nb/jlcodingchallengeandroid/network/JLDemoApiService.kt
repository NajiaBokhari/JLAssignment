package com.nb.jlcodingchallengeandroid.network

import retrofit2.http.GET

interface JLDemoApiService {
    @GET("call")
    suspend fun getCallingList(): ArrayList<ItemsListResponseDTO>

    @GET("buy")
    suspend fun getBuyList(): ArrayList<ItemsListResponseDTO>
}