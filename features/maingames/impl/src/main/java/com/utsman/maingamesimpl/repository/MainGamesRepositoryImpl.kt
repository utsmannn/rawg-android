package com.utsman.maingamesimpl.repository

import com.utsman.maingamesimpl.utils.Mapper
import com.utsman.rawg.core.mapObservable
import com.utsman.rawg.maingameapi.api.MainGameWebServices
import com.utsman.rawg.maingameapi.repository.MainGamesRepository
import com.utsman.rawg.maingameapi.data.local.GamesDto
import com.utsman.rawg.maingameapi.data.remote.GamesParams
import io.reactivex.rxjava3.core.Observable

class MainGamesRepositoryImpl(private val webServices: MainGameWebServices) : MainGamesRepository {
    override fun getLatestGame(page: Int): Observable<List<GamesDto>> {
        val params = GamesParams(
            page = page,
            ordering = GamesParams.Ordering.RELEASE
        )

        return webServices.getGames(params = params.toMapParams())
            .mapObservable {
                Mapper.mapGameResponseToDto(it)
            }
    }

    override fun getTopRatingGame(page: Int): Observable<List<GamesDto>> {
        val params = GamesParams(
            page = page,
            ordering = GamesParams.Ordering.RATING
        )

        return webServices.getGames(params = params.toMapParams())
            .mapObservable {
                Mapper.mapGameResponseToDto(it)
            }
    }

    override fun getSearchGame(query: String, page: Int): Observable<List<GamesDto>> {
        val params = GamesParams(
            page = page
        )

        return webServices.getGames(params = params.toMapParamSearch(query))
            .mapObservable {
                Mapper.mapGameResponseToDto(it)
            }
    }
}