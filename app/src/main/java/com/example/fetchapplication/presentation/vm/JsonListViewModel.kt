package com.example.fetchapplication.presentation.vm

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchapplication.domain.repository.GetListRepository
import com.example.fetchapplication.domain.usecase.GetListUseCase
import com.example.fetchapplication.presentation.model.JsonListModel
import com.example.fetchapplication.presentation.view.AdpJsonList
import kotlinx.coroutines.launch

class JsonListViewModel: ViewModel(){
    private val repo = GetListUseCase()
    private lateinit var adapter: AdpJsonList
    var adpList: MutableLiveData<AdpJsonList> = MutableLiveData()
    fun apiCall(){
        viewModelScope.launch {
            val list = repo.getListApi()
            adapter = AdpJsonList(list)
            adpList.postValue(adapter)
        }
    }
    fun NofilterName(){
        viewModelScope.launch {
            val res = repo.getListApi()
            val list = res.sortedWith(compareBy{it.listId})
            adapter = AdpJsonList(list)
            adpList.postValue(adapter)
        }
    }
    fun filterName(){
        viewModelScope.launch {
            val res = repo.getListApi()
            val list = res.sortedWith(compareBy{it.listId}).filter{it.name!=null && it.name!=""}
            adapter = AdpJsonList(list)
            adpList.postValue(adapter)
        }
    }
}