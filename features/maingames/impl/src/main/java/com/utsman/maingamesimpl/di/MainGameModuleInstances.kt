package com.utsman.maingamesimpl.di

import com.utsman.maingamesimpl.presenter.viewmodel.MainGameViewModel
import com.utsman.maingamesimpl.repository.MainGamesRepositoryImpl
import com.utsman.rawg.core.Constant
import com.utsman.rawg.maingameapi.api.MainGameWebServices
import com.utsman.rawg.maingameapi.repository.MainGamesRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object MainGameModuleInstances {

    fun getMainGameWebService(): MainGameWebServices {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(Constant.WebService.BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MainGameWebServices::class.java)
    }

    fun getMainGameRepository(webServices: MainGameWebServices) : MainGamesRepository {
        return MainGamesRepositoryImpl(webServices)
    }

    fun getMainGameViewModel(mainGamesRepository: MainGamesRepository): MainGameViewModel {
        return MainGameViewModel(mainGamesRepository)
    }
}