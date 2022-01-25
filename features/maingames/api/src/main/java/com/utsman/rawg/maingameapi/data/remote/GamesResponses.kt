package com.utsman.rawg.maingameapi.data.remote


import com.google.gson.annotations.SerializedName

data class GamesResponses(
    @SerializedName("count")
    val count: Int? = 0,
    @SerializedName("next")
    val next: String? = "",
    @SerializedName("previous")
    val previous: Any? = Any(),
    @SerializedName("results")
    val results: List<Result?>? = listOf(),
    @SerializedName("user_platforms")
    val userPlatforms: Boolean? = false
) {
    data class Result(
        @SerializedName("added")
        val added: Int? = 0,
        @SerializedName("added_by_status")
        val addedByStatus: AddedByStatus? = AddedByStatus(),
        @SerializedName("background_image")
        val backgroundImage: String? = "",
        @SerializedName("clip")
        val clip: Any? = Any(),
        @SerializedName("community_rating")
        val communityRating: Int? = 0,
        @SerializedName("dominant_color")
        val dominantColor: String? = "",
        @SerializedName("esrb_rating")
        val esrbRating: EsrbRating? = null,
        @SerializedName("genres")
        val genres: List<Genre?>? = listOf(),
        @SerializedName("id")
        val id: Int? = 0,
        @SerializedName("metacritic")
        val metacritic: Any? = Any(),
        @SerializedName("name")
        val name: String? = "",
        @SerializedName("parent_platforms")
        val parentPlatforms: List<ParentPlatform?>? = listOf(),
        @SerializedName("platforms")
        val platforms: List<Platform?>? = listOf(),
        @SerializedName("playtime")
        val playtime: Int? = 0,
        @SerializedName("rating")
        val rating: Double? = 0.0,
        @SerializedName("rating_top")
        val ratingTop: Int? = 0,
        @SerializedName("ratings")
        val ratings: List<Any?>? = listOf(),
        @SerializedName("ratings_count")
        val ratingsCount: Int? = 0,
        @SerializedName("released")
        val released: String? = "",
        @SerializedName("reviews_count")
        val reviewsCount: Int? = 0,
        @SerializedName("reviews_text_count")
        val reviewsTextCount: Int? = 0,
        @SerializedName("saturated_color")
        val saturatedColor: String? = "",
        @SerializedName("score")
        val score: Any? = Any(),
        @SerializedName("short_screenshots")
        val shortScreenshots: List<ShortScreenshot?>? = listOf(),
        @SerializedName("slug")
        val slug: String? = "",
        @SerializedName("stores")
        val stores: List<Store?>? = listOf(),
        @SerializedName("suggestions_count")
        val suggestionsCount: Int? = 0,
        @SerializedName("tags")
        val tags: List<Tag?>? = listOf(),
        @SerializedName("tba")
        val tba: Boolean? = false,
        @SerializedName("updated")
        val updated: String? = "",
        @SerializedName("user_game")
        val userGame: Any? = Any()
    ) {
        data class AddedByStatus(
            @SerializedName("owned")
            val owned: Int? = 0,
            @SerializedName("toplay")
            val toplay: Int? = 0
        )

        data class Genre(
            @SerializedName("id")
            val id: Int? = 0,
            @SerializedName("name")
            val name: String? = "",
            @SerializedName("slug")
            val slug: String? = ""
        )

        data class ParentPlatform(
            @SerializedName("platform")
            val platform: Platform? = Platform()
        ) {
            data class Platform(
                @SerializedName("id")
                val id: Int? = 0,
                @SerializedName("name")
                val name: String? = "",
                @SerializedName("slug")
                val slug: String? = ""
            )
        }

        data class Platform(
            @SerializedName("platform")
            val platform: Platform? = Platform()
        ) {
            data class Platform(
                @SerializedName("id")
                val id: Int? = 0,
                @SerializedName("name")
                val name: String? = "",
                @SerializedName("slug")
                val slug: String? = ""
            )
        }

        data class ShortScreenshot(
            @SerializedName("id")
            val id: Int? = 0,
            @SerializedName("image")
            val image: String? = ""
        )

        data class Store(
            @SerializedName("store")
            val store: Store? = Store()
        ) {
            data class Store(
                @SerializedName("id")
                val id: Int? = 0,
                @SerializedName("name")
                val name: String? = "",
                @SerializedName("slug")
                val slug: String? = ""
            )
        }

        data class Tag(
            @SerializedName("games_count")
            val gamesCount: Int? = 0,
            @SerializedName("id")
            val id: Int? = 0,
            @SerializedName("image_background")
            val imageBackground: String? = "",
            @SerializedName("language")
            val language: String? = "",
            @SerializedName("name")
            val name: String? = "",
            @SerializedName("slug")
            val slug: String? = ""
        )

        data class EsrbRating(
            @SerializedName("id")
            val id: Int = 0,
            @SerializedName("name")
            val name: String = ""
        )
    }
}