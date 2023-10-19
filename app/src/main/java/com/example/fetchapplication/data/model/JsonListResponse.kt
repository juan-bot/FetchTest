package com.example.fetchapplication.data.model

import com.google.gson.annotations.SerializedName

data class JsonListResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("listId")
    val listId: Int,
    @SerializedName("name")
    val name: String
)