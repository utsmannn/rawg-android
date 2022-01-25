package com.utsman.rawg.maingameapi.repository

import com.utsman.rawg.maingameapi.data.local.GamesDto
import io.reactivex.rxjava3.core.Observable

interface MainGamesRepository {
    fun getLatestGame(page: Int): Observable<List<GamesDto>>
    fun getTopRatingGame(page: Int): Observable<List<GamesDto>>
    fun getSearchGame(query: String, page: Int): Observable<List<GamesDto>>
}