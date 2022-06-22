package com.example.myapplication.doglist

import com.example.myapplication.Dog
import com.example.myapplication.api.ApiResponseStatus
import com.example.myapplication.api.DogsApi.retrofitService
import com.example.myapplication.api.dto.DogDTOMapper
import com.example.myapplication.api.makeNetworkCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.net.UnknownHostException

class DogRepository {

    suspend fun downloadDogs(): ApiResponseStatus<List<Dog>> = makeNetworkCall {
        val dogListApiResponse = retrofitService.getAllDogs()
        val dogDTOList = dogListApiResponse.data.dogs
        val dogDTOMapped = DogDTOMapper()
        dogDTOMapped.fromDogDTOListToDogDomainList(dogDTOList)
    }

}