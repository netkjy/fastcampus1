package com.betona.fastcampus1.data.respository

import com.betona.fastcampus1.data.entity.RestaurantEntity
import com.betona.fastcampus1.screen.main.home.restaurant.RestaurantCategory

interface RestaurantRespository {
    suspend fun getList(
        restaurantCategory: RestaurantCategory
    ) : List<RestaurantEntity>
}