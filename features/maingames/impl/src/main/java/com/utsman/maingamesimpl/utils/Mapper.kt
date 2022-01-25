package com.utsman.maingamesimpl.utils

import com.utsman.rawg.core.orZero
import com.utsman.rawg.maingameapi.data.local.GamesDto
import com.utsman.rawg.maingameapi.data.remote.GamesResponses

object Mapper {

    private fun mapResultToDto(gameResult: GamesResponses.Result?): GamesDto {
        val esrbRating = GamesDto.EsrbRating(
            id = gameResult?.esrbRating?.id.orZero(),
            name = gameResult?.esrbRating?.name.orEmpty()
        )

        return GamesDto(
            id = gameResult?.id.orZero().toLong(),
            name = gameResult?.name.orEmpty(),
            platform = gameResult?.platforms?.map { it?.platform?.name.orEmpty() }.orEmpty(),
            releaseDate = gameResult?.released.orEmpty(),
            backgroundImage = gameResult?.backgroundImage.orEmpty(),
            images = gameResult?.shortScreenshots?.map { it?.image.orEmpty() }.orEmpty(),
            esrbRating = esrbRating,
            genres = gameResult?.genres?.map { it?.name.orEmpty() }.orEmpty(),
            tags = gameResult?.tags?.map { it?.name.orEmpty() }.orEmpty()
        )

    }

    fun mapGameResponseToDto(gamesResponses: GamesResponses?): List<GamesDto> {
        return gamesResponses?.results?.map { mapResultToDto(it) }.orEmpty()
    }
}