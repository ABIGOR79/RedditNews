package com.example.myappapi

import data.DataSource
import data.LocalDataSourceImpl
import data.RemoteDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module
import repo.PostRepository
import repo.PostRepositoryImpl
import sharedPref.MySharedPreferences

val appModule = module {


    single { MySharedPreferences(androidContext()) }

    single { (view: MainContract)-> MainPresenter(get(), view) }
    factory { GetNewsListUseCase(get()) }
    single<PostRepository> { PostRepositoryImpl(get(named("local")), get(named("remote")), get()) }
    single<DataSource>(named("local")) { LocalDataSourceImpl() }
    single<DataSource>(named("remote")) { RemoteDataSource(get()) }
    single { Retrofit.retrofitService }

    }