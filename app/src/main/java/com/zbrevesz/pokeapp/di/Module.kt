package com.zbrevesz.pokeapp.di

import com.google.gson.GsonBuilder
import com.zbrevesz.pokeapp.remote.RemoteServiceInterface
import com.zbrevesz.pokeapp.viewModel.PokeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val pokeModule: Module = module {

    factory {
        Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    viewModel {
        PokeViewModel(get())
    }

    single {
        get<Retrofit>().create(RemoteServiceInterface::class.java)
    }
}