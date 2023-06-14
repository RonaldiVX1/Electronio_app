package com.example.electronioproject.ui.screen.utils

data class LoadingState<T> constructor(val status: Status, val msg: String? = null) {
    companion object {
        val SUCCESS = LoadingState<Any>(Status.SUCCESS)
        val IDLE = LoadingState<Any>(Status.IDLE)
        val LOADING = LoadingState<Any>(Status.LOADING)
        fun error(msg: String?) = LoadingState<Any>(Status.FAILED, msg)
    }

    enum class Status {
        LOADING,
        SUCCESS,
        FAILED,
        IDLE,
    }
}