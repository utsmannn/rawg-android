package com.utsman.rawg.maingameapi.data.local

data class GamesDto(
    val id: Long = 0L,
    val name: String = "",
    val platform: List<String> = emptyList(),
    val releaseDate: String = "",
    val backgroundImage: String = "",
    val images: List<String> = emptyList(),
    val esrbRating: EsrbRating = EsrbRating(),
    val genres: List<String> = emptyList(),
    val tags: List<String> = emptyList()
) {
    data class EsrbRating(
        val id: Int = 0,
        val name: String = ""
    )
}