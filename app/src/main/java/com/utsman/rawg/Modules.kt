package com.utsman.rawg

import com.utsman.maingamesimpl.di.MainGameModuleInstances
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Modules {

    val modules = module {
        single { MainGameModuleInstances.getMainGameWebService() }
        single { MainGameModuleInstances.getMainGameRepository(get()) }
        viewModel { MainGameModuleInstances.getMainGameViewModel(get()) }
    }
}