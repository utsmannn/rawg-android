package com.utsman.rawg.maingameapi.api

import com.utsman.rawg.maingameapi.data.remote.GamesResponses
import io.reactivex.rxjava3.core.Observable
import retrofit2.Response

typealias GamesResponseObservable = Observable<Response<GamesResponses>>
typealias GamesParam = MainGameWebServices.QueryParam