package com.utsman.rawg.core

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView

fun AppCompatActivity.findButton(@IdRes id: Int): Button = findViewById(id)
fun AppCompatActivity.findTextView(@IdRes id: Int): TextView = findViewById(id)
fun AppCompatActivity.findImageView(@IdRes id: Int): ImageView = findViewById(id)
fun AppCompatActivity.findRecyclerView(@IdRes id: Int): RecyclerView = findViewById(id)

fun FragmentActivity.findButton(@IdRes id: Int): Button = findViewById(id)
fun FragmentActivity.findTextView(@IdRes id: Int): TextView = findViewById(id)
fun FragmentActivity.findImageView(@IdRes id: Int): ImageView = findViewById(id)
fun FragmentActivity.findRecyclerView(@IdRes id: Int): RecyclerView = findViewById(id)

fun View.findButton(@IdRes id: Int): Button = findViewById(id)
fun View.findTextView(@IdRes id: Int): TextView = findViewById(id)
fun View.findImageView(@IdRes id: Int): ImageView = findViewById(id)
fun View.findRecyclerView(@IdRes id: Int): RecyclerView = findViewById(id)