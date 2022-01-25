package com.utsman.maingamesimpl.presenter.fragment

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.utsman.maingamesimpl.R
import com.utsman.maingamesimpl.presenter.viewmodel.MainGameViewModel
import com.utsman.maingamesimpl.presenter.screen.StateScreen
import com.utsman.maingamesimpl.presenter.adapter.MainGameAdapter
import com.utsman.rawg.core.NetworkException
import com.utsman.rawg.maingameapi.data.local.GamesDto
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainGameFragment : Fragment(R.layout.fragment_main_game) {

    private val viewModel: MainGameViewModel by viewModel()
    private val topAdapter = MainGameAdapter()
    private val latestAdapter = MainGameAdapter()

    private val progressBar: ProgressBar? by lazy {
        view?.findViewById(R.id.pb_main)
    }

    private val tvErrorMessage: TextView? by lazy {
        view?.findViewById(R.id.tv_error_message)
    }

    private val rvTopGame: RecyclerView? by lazy {
        view?.findViewById(R.id.rv_main_game_top)
    }

    private val rvLatestGame: RecyclerView? by lazy {
        view?.findViewById(R.id.rv_main_game_latest)
    }

    private val tvTopGame: TextView? by lazy {
        view?.findViewById(R.id.tv_title_top)
    }

    private val tvLatestGame: TextView? by lazy {
        view?.findViewById(R.id.tv_title_latest)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvTopGame?.run {
            setupGrid()
            adapter = topAdapter
        }

        rvLatestGame?.run {
            setupGrid()
            adapter = latestAdapter
        }

        hideLoadingAndError()

        viewModel.bindTopStateScreen(object : StateScreen<List<GamesDto>> {
            override fun onLoading() {
                showLoading()
            }

            override fun onSuccess(data: List<GamesDto>) {
                hideLoadingAndError()
                topAdapter.addGame(data)
            }

            override fun onFailure(networkException: NetworkException) {
                showError(networkException.message)
            }
        })

        viewModel.bindLatestStateScreen(object : StateScreen<List<GamesDto>> {
            override fun onLoading() {
                showLoading()
            }

            override fun onSuccess(data: List<GamesDto>) {
                hideLoadingAndError()
                latestAdapter.addGame(data)
            }

            override fun onFailure(networkException: NetworkException) {
                showError(networkException.message)
            }
        })

        viewModel.getTopGames()
        viewModel.getLatestGames()
    }

    private fun hideLoadingAndError() {
        progressBar?.isVisible = false
        tvErrorMessage?.isVisible = false
        tvTopGame?.isVisible = true
        tvLatestGame?.isVisible = true
    }

    private fun showLoading() {
        progressBar?.isVisible = true
        tvErrorMessage?.isVisible = false
        tvTopGame?.isVisible = false
        tvLatestGame?.isVisible = false
    }

    private fun showError(message: String?) {
        progressBar?.isVisible = false
        tvErrorMessage?.isVisible = true
        tvErrorMessage?.text = message

        tvTopGame?.isVisible = false
        tvLatestGame?.isVisible = false
    }

    private fun RecyclerView.setupGrid() {
        layoutManager = GridLayoutManager(context, 2, RecyclerView.HORIZONTAL, false)
    }
}