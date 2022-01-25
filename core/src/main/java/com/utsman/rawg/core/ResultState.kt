package com.utsman.rawg.core

sealed class ResultState<T: Any> {
    class Loading<T: Any> : ResultState<T>()
    data class Success<T: Any>(val data: T) : ResultState<T>()
    data class Error<T: Any>(val exception: NetworkException): ResultState<T>()
}