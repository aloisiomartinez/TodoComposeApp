package com.example.todocompose.util

sealed class RequestState<out T> {
    object idle : RequestState<Nothing>()
    object loading : RequestState<Nothing>()
    data class Success<T>(val data: T): RequestState<T>()
    data class Error(val error: Throwable): RequestState<Nothing>()
}