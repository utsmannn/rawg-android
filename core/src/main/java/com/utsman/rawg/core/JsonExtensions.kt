package com.utsman.rawg.core

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

private fun getGsonPretty(): Gson = GsonBuilder()
    .setPrettyPrinting()
    .create()

fun <T : Any> T.toJsonString(): String {
    val gson = getGsonPretty()
    val type = object : TypeToken<T>() {}.type
    return gson.toJson(this, type)
}

fun <T : Any> String.fromJsonString(): T {
    val gson = getGsonPretty()
    val type = object : TypeToken<T>() {}.type
    return gson.fromJson(this, type)
}