package com.utsman.maingamesimpl.presenter.screen

import com.utsman.rawg.core.NetworkException

interface StateScreen<T: Any> {
    fun onLoading()
    fun onSuccess(data: T)
    fun onFailure(networkException: NetworkException)
}