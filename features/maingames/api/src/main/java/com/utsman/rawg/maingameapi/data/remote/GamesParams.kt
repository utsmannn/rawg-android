package com.utsman.rawg.maingameapi.data.remote

import com.utsman.rawg.core.Constant
import com.utsman.rawg.maingameapi.api.GamesParam

data class GamesParams(
    val key: String = Constant.WebService.API_KEY,
    val pageSize: Int = 10,
    val ordering: Ordering = Ordering.RELEASE,
    val platform: Int = 4,
    val page: Int = 1,
    val dates: String = Constant.WebService.DATE
) {
    enum class Ordering(val value: String) {
        RELEASE("-released"),
        RATING("-rating")
    }

    fun toMapParams(): Map<String, Any> {
        return mapOf(
            GamesParam.KEY to key,
            GamesParam.PAGE_SIZE to pageSize,
            GamesParam.ORDERING to ordering.value,
            GamesParam.PLATFORMS to platform,
            GamesParam.PAGE to page,
            GamesParam.DATES to dates
        )
    }

    fun toMapParamSearch(query: String): Map<String, Any> {
        return mapOf(
            GamesParam.KEY to key,
            GamesParam.PAGE_SIZE to pageSize,
            GamesParam.PLATFORMS to platform,
            GamesParam.PAGE to page,
            GamesParam.DATES to dates,
            GamesParam.SEARCH to query
        )
    }
}