package com.utsman.rawg.core

class NetworkException(message: String? = "", val code: Int = 500) : Throwable(message) {
    override fun getLocalizedMessage(): String {
        return "Code: $code, message: $message"
    }
}