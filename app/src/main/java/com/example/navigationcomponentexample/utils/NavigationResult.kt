package com.example.navigationcomponentexample.utils

import java.io.Serializable

interface NavigationResult : Serializable {
    companion object {
        val RESULT_OK = 0
        val RESULT_ERROR = 1
    }
    fun setResult(result: Int)
}