package com.betona.fastcampus1.di

import com.betona.fastcampus1.screen.main.home.HomeFragment
import com.betona.fastcampus1.screen.main.home.HomeViewModel
import com.betona.fastcampus1.screen.main.my.MyViewModel
import com.betona.fastcampus1.util.provider.DefaultResourcesProvider
import com.betona.fastcampus1.util.provider.ResourcesProvider
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import kotlin.system.exitProcess

val appModule = module {
    viewModel { HomeViewModel() }
    viewModel { MyViewModel() }

    single { provideGsonConvertFactory() }
    single { buildOkHttpClient() }
    single { provideRetrofit(get(),get()) }
    single<ResourcesProvider> { DefaultResourcesProvider(androidApplication()) }

    single { Dispatchers.IO}
    single { Dispatchers.Main}
}