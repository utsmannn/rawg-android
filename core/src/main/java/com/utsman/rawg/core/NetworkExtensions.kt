package com.utsman.rawg.core

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response
import java.util.concurrent.TimeUnit

fun <T : Any, U : Any> Observable<Response<T>>.mapObservable(bodyMapper: (T?) -> U): Observable<U> {
    return flatMap {
            if (it.isSuccessful) {
                val data = bodyMapper.invoke(it.body())
                Observable.just(data)
            } else {
                val exception = NetworkException(it.errorBody()?.string(), it.code())
                Observable.error(exception)
            }
        }
}

fun <U : Any> Observable<U>.fetchSubscribe(onSubscribeResult: (ResultState<U>) -> Unit): Disposable {
    return subscribeOn(Schedulers.io())
        .delay(2000, TimeUnit.MILLISECONDS)
        .observeOn(AndroidSchedulers.mainThread())
        .doOnSubscribe {
            onSubscribeResult.invoke(ResultState.Loading())
        }
        .subscribe({
            onSubscribeResult.invoke(ResultState.Success(it))
        }, {
            if (it is NetworkException) {
                onSubscribeResult.invoke(ResultState.Error(it))
            } else {
                onSubscribeResult.invoke(ResultState.Error(NetworkException(it.localizedMessage)))
            }
        })
}