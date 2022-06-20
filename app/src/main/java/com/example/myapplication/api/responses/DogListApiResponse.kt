package com.example.myapplication.api.responses

import com.squareup.moshi.Json

class DogListApiResponse(val message: String,
                         @field:Json(name = "is_success") val inSuccess: Boolean,
                         val data: DogListResponse)