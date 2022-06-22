package com.example.myapplication.doglist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.Dog
import com.example.myapplication.api.ApiResponseStatus
import kotlinx.coroutines.launch
import java.lang.Exception

class DogListViewModel : ViewModel() {

    private val _dogList = MutableLiveData<List<Dog>>()
    val dogList: LiveData<List<Dog>>
        get() = _dogList

    private val _status = MutableLiveData<ApiResponseStatus<List<Dog>>>()
    val status: LiveData<ApiResponseStatus<List<Dog>>>
        get() = _status

    private val dogRepository = DogRepository()

    init {
        downloadDogs()
    }

    private fun downloadDogs(){
        viewModelScope.launch {
            _status.value = ApiResponseStatus.Loading("Cargando")
           handleResponseStatus(dogRepository.downloadDogs())
        }
    }

    private fun handleResponseStatus(item: ApiResponseStatus<List<Dog>>) {
        if(item is ApiResponseStatus.Success){
            _dogList.value = item.data
        }
        _status.value = item
    }
}