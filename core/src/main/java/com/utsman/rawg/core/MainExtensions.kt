package com.utsman.rawg.core

import android.content.Context
import android.widget.Toast

fun Context.toast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
fun Any.simpleLog(message: String) = println("${this.javaClass.simpleName}: $message")

fun Int?.orZero(): Int = this ?: 0