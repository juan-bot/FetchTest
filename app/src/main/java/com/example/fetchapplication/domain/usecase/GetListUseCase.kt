package com.example.fetchapplication.domain.usecase

import com.example.fetchapplication.domain.repository.GetListRepository
import com.example.fetchapplication.presentation.model.JsonListModel

class GetListUseCase {
    private val repository = GetListRepository()
    suspend fun getListApi(): List<JsonListModel>{
        val response = repository.getListApi()
        val list : MutableList<JsonListModel> = arrayListOf()

        for (i in response.indices) {
            val model = JsonListModel(
                id = response[i].id,
                listId = response[i].listId,
                name = response[i].name
            )
            list.add(model)
        }
        return list
    }
}