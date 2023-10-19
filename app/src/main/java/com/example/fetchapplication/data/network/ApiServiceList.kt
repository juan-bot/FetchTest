package com.example.fetchapplication.data.network

import com.example.fetchapplication.data.model.JsonListResponse
import retrofit2.http.GET

interface ApiServiceList {
    @GET("/hiring.json")
    suspend fun getListInfo(): List<JsonListResponse>
}