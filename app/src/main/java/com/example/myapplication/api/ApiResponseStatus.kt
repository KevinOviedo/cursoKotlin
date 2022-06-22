package com.example.myapplication.api

import com.example.myapplication.Dog


sealed class ApiResponseStatus<T>() {
    class Success<T>(val data: T) : ApiResponseStatus<T>()
    class Loading<T>(val message: String) : ApiResponseStatus<T>()
    class Error<T>(val messageId: String) : ApiResponseStatus<T>()
}
