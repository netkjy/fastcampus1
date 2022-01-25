package com.betona.fastcampus1.di

import com.betona.fastcampus1.util.provider.DefaultResourcesProvider
import com.betona.fastcampus1.util.provider.ResourcesProvider
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import kotlin.system.exitProcess

val appModule = module {
    single { provideGsonConvertFactory() }
    single { buildOkHttpClient() }
    single { provideRetrofit(get(),get()) }
    single<ResourcesProvider> { DefaultResourcesProvider(androidApplication()) }

    single { Dispatchers.IO}
    single { Dispatchers.Main}
}