package com.betona.fastcampus1.widget.adapter.listener

import com.betona.fastcampus1.model.restaurant.RestaurantModel

interface RestaurantListListener:AdapterListener {
    fun onClickItem(model: RestaurantModel)
}