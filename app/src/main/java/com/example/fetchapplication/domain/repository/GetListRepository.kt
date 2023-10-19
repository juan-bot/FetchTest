package com.example.fetchapplication.domain.repository

import com.example.fetchapplication.data.model.JsonListResponse
import com.example.fetchapplication.data.network.RetrofitList

class GetListRepository {
    suspend fun getListApi(): List<JsonListResponse>{
        return RetrofitList.api().getListInfo()
    }
}