package com.example.main_page.di

import androidx.room.Room
import com.example.common.InjectionModule
import com.example.main_page.api.MainApi
import com.example.main_page.db.database.AppDatabase
import com.example.main_page.interactor.MainInteractor
import com.example.main_page.repository.local.MainLocalRepository
import com.example.main_page.repository.local.MainLocalRepositoryImpl
import com.example.main_page.repository.remote.MainRemoteRepository
import com.example.main_page.repository.remote.MainRepository
import com.example.main_page.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

object MainModule : InjectionModule {

    override fun create() = module {
        single { get<Retrofit>().create(MainApi::class.java) }
        single {
            Room.databaseBuilder(get(), AppDatabase::class.java, "GamesDatabase")
                .build()
        }
        single { get<AppDatabase>().getGenresDao() }
        single { get<AppDatabase>().getGamesDao() }
        single { MainRemoteRepository(get()) } bind MainRepository::class
        single { MainLocalRepositoryImpl(get(), get()) } bind MainLocalRepository::class
        factoryOf(::MainInteractor)

        viewModelOf(::MainViewModel)
    }
}