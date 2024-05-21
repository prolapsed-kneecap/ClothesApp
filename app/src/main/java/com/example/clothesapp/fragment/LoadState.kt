package com.example.clothesapp.fragment

sealed class LoadState<out T> {
    object Loading : LoadState<Nothing>()
    class Success<T>(val data: T) : LoadState<T>()
    class Error<T>(val e: Throwable) : LoadState<T>()
}
