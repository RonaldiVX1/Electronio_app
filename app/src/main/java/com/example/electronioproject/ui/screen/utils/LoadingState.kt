package com.example.electronioproject.ui.screen.utils

data class LoadingState constructor(val status: Status, val msg: String? = null) {
    companion object {
        val SUCCESS = LoadingState(Status.SUCCESS)
        val IDLE = LoadingState(Status.IDLE)
        val LOADING = LoadingState(Status.RUNNING)
        fun error(msg: String?) = LoadingState(Status.FAILED, msg)
    }

    enum class Status {
        RUNNING,
        SUCCESS,
        FAILED,
        IDLE,
    }
}