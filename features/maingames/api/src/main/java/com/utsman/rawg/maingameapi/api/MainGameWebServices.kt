package com.utsman.rawg.maingameapi.api

import retrofit2.http.GET
import retrofit2.http.QueryMap

@JvmSuppressWildcards
interface MainGameWebServices {

    @GET(GAMES)
    fun getGames(
        @QueryMap params: Map<String, Any>
    ) : GamesResponseObservable

    companion object Endpoints {
        private const val GAMES = "/api/games"
    }

    object QueryParam {
        const val KEY = "key" // string
        const val PAGE_SIZE = "page_size" // integer
        const val ORDERING = "ordering" // string : -released, -rating
        const val PLATFORMS = "platforms" // integer
        const val PAGE = "page" // integer
        const val DATES = "dates" // string range : 2021-12-01,2021-12-31
        const val SEARCH = "search" // string
    }
}