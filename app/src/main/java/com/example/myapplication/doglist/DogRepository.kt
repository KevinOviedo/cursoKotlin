package com.example.myapplication.doglist

import com.example.myapplication.Dog
import com.example.myapplication.api.DogsApi.retrofitService
import com.example.myapplication.api.dto.DogDTOMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DogRepository {

    suspend fun downloadDogs(): List<Dog> {
        return withContext(Dispatchers.IO) {
            val dogListApiResponse = retrofitService.getAllDogs()
            val dogDTOList = dogListApiResponse.data.dogs
            val dogDTOMapped = DogDTOMapper()
            dogDTOMapped.fromDogDTOListToDogDomainList(dogDTOList)
        }
    }
}