package com.utsman.maingamesimpl.presenter.fragment

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.rxbinding4.widget.textChanges
import com.utsman.maingamesimpl.R
import com.utsman.maingamesimpl.presenter.adapter.MainGameAdapter
import com.utsman.maingamesimpl.presenter.screen.StateScreen
import com.utsman.maingamesimpl.presenter.viewmodel.MainGameViewModel
import com.utsman.rawg.core.NetworkException
import com.utsman.rawg.maingameapi.data.local.GamesDto
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.concurrent.TimeUnit

class SearchGameFragment : Fragment(R.layout.fragment_search_game) {
    private val viewModel: MainGameViewModel by viewModel()
    private val searchAdapter = MainGameAdapter()

    private val editText: EditText? by lazy {
        view?.findViewById(R.id.search_bar)
    }

    private val rvResultGame: RecyclerView? by lazy {
        view?.findViewById(R.id.rv_result_game)
    }

    private val progressBar: ProgressBar? by lazy {
        view?.findViewById(R.id.pb_main)
    }

    private val tvErrorMessage: TextView? by lazy {
        view?.findViewById(R.id.tv_error_message)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvResultGame?.run {
            layoutManager = GridLayoutManager(context, 4, RecyclerView.VERTICAL, false)
            adapter = searchAdapter
        }

        hideLoadingAndError()

        viewModel.bindSearchStateScreen(object : StateScreen<List<GamesDto>> {
            override fun onLoading() {
                showLoading()
            }

            override fun onSuccess(data: List<GamesDto>) {
                hideLoadingAndError()
                searchAdapter.addGame(data)
            }

            override fun onFailure(networkException: NetworkException) {
                showError(networkException.message)
            }
        })

        editText?.run {
            textChanges()
                .subscribeOn(Schedulers.io())
                .debounce(1000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .map { it.toString() }
                .filter { it.length > 2 }
                .subscribe({
                    searchAdapter.clearGame()
                    viewModel.getSearchGame(it)
                }, {
                    it.printStackTrace()
                })
        }
    }

    private fun hideLoadingAndError() {
        progressBar?.isVisible = false
        tvErrorMessage?.isVisible = false
        editText?.isEnabled = true
    }

    private fun showLoading() {
        progressBar?.isVisible = true
        tvErrorMessage?.isVisible = false
        editText?.isEnabled = false
    }

    private fun showError(message: String?) {
        progressBar?.isVisible = false
        tvErrorMessage?.isVisible = true
        tvErrorMessage?.text = message

        editText?.isEnabled = true
    }
}