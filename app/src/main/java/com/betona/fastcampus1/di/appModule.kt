package com.betona.fastcampus1.di

import com.betona.fastcampus1.data.respository.DefaultRestaurantRespository
import com.betona.fastcampus1.data.respository.RestaurantRespository
import com.betona.fastcampus1.screen.main.home.HomeViewModel
import com.betona.fastcampus1.screen.main.home.restaurant.RestaurantCategory
import com.betona.fastcampus1.screen.main.home.restaurant.RestaurantListViewModel
import com.betona.fastcampus1.screen.main.my.MyViewModel
import com.betona.fastcampus1.util.provider.DefaultResourcesProvider
import com.betona.fastcampus1.util.provider.ResourcesProvider
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {
    viewModel { HomeViewModel() }
    viewModel { MyViewModel() }
    viewModel { (restaurantCategory: RestaurantCategory) -> RestaurantListViewModel(restaurantCategory,get()) }

    single<RestaurantRespository> { DefaultRestaurantRespository(get(),get()) }

    single { provideGsonConvertFactory() }
    single { buildOkHttpClient() }
    single { provideRetrofit(get(),get()) }
    single<ResourcesProvider> { DefaultResourcesProvider(androidApplication()) }

    single { Dispatchers.IO}
    single { Dispatchers.Main}
}