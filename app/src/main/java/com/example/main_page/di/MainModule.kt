package com.example.main_page.di

import com.example.common.InjectionModule
import com.example.main_page.api.MainApi
import com.example.main_page.ui.MainViewModel
import com.example.main_page.interactor.MainInteractor
import com.example.main_page.repository.MainRemoteRepository
import com.example.main_page.repository.MainRepository
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

object MainModule: InjectionModule {

    override fun create() = module {
        single { get<Retrofit>().create(MainApi::class.java) }
        single { MainRemoteRepository(get()) } bind MainRepository::class
        factoryOf(::MainInteractor)

        viewModelOf(::MainViewModel)
    }
}