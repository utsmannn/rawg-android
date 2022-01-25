package com.utsman.maingamesimpl.presenter.viewmodel

import androidx.lifecycle.ViewModel
import com.utsman.maingamesimpl.presenter.screen.StateScreen
import com.utsman.rawg.core.ResultState
import com.utsman.rawg.core.fetchSubscribe
import com.utsman.rawg.maingameapi.repository.MainGamesRepository
import com.utsman.rawg.maingameapi.data.local.GamesDto

class MainGameViewModel(private val mainGamesRepository: MainGamesRepository) : ViewModel() {
    private var topStateScreen: StateScreen<List<GamesDto>>? = null
    private var latestStateScreen: StateScreen<List<GamesDto>>? = null
    private var searchStateScreen: StateScreen<List<GamesDto>>? = null

    fun bindTopStateScreen(stateScreen: StateScreen<List<GamesDto>>) {
        topStateScreen = stateScreen
    }

    fun bindLatestStateScreen(stateScreen: StateScreen<List<GamesDto>>) {
        latestStateScreen = stateScreen
    }

    fun bindSearchStateScreen(stateScreen: StateScreen<List<GamesDto>>) {
        searchStateScreen = stateScreen
    }

    fun getTopGames() {
        mainGamesRepository.getTopRatingGame(1)
            .fetchSubscribe {
                when (it) {
                    is ResultState.Loading -> topStateScreen?.onLoading()
                    is ResultState.Success -> topStateScreen?.onSuccess(it.data)
                    is ResultState.Error -> topStateScreen?.onFailure(it.exception)
                }
            }
    }

    fun getLatestGames() {
        mainGamesRepository.getLatestGame(1)
            .fetchSubscribe {
                when (it) {
                    is ResultState.Loading -> latestStateScreen?.onLoading()
                    is ResultState.Success -> latestStateScreen?.onSuccess(it.data)
                    is ResultState.Error -> latestStateScreen?.onFailure(it.exception)
                }
            }
    }

    fun getSearchGame(query: String) {
        mainGamesRepository.getSearchGame(query, 1)
            .fetchSubscribe {
                when (it) {
                    is ResultState.Loading -> searchStateScreen?.onLoading()
                    is ResultState.Success -> searchStateScreen?.onSuccess(it.data)
                    is ResultState.Error -> searchStateScreen?.onFailure(it.exception)
                }
            }
    }
}