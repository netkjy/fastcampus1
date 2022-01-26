package com.betona.fastcampus1.model.restaurant

import android.graphics.ColorSpace
import com.betona.fastcampus1.data.entity.RestaurantEntity
import com.betona.fastcampus1.model.CellType
import com.betona.fastcampus1.model.Model
import com.betona.fastcampus1.screen.main.home.restaurant.RestaurantCategory
import com.betona.fastcampus1.widget.adapter.ModelRecyclerAdapter

data class RestaurantModel(
    override val id:Long,
    override val type: CellType = CellType.RESTAURANT_CELL,
    val restaurantInfoId:Long,
    val restaurantCategory: RestaurantCategory,
    val restaurantTitle: String,
    val restaurantImageUrl:String,
    val grade: Float,
    val reviewCount: Int,
    val deliveryTimeRange: Pair<Int,Int>,
    val deliveryTipRange: Pair<Int,Int>
): Model(id,type) {
    fun tpEntity() = RestaurantEntity(
        id,
        restaurantInfoId,
        restaurantCategory,
        restaurantTitle,
        restaurantImageUrl,
        grade,
        reviewCount,
        deliveryTimeRange,
        deliveryTipRange
    )
}
