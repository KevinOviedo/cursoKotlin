package com.example.myapplication.api

import com.example.myapplication.BASE_URL
import com.example.myapplication.Dog
import com.example.myapplication.GET_ALL_DOGS
import com.example.myapplication.api.responses.DogListApiResponse
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private  val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

interface ApiService {

        @GET(GET_ALL_DOGS)
        suspend fun getAllDogs() : DogListApiResponse

}

object DogsApi{
    val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}