package com.betona.fastcampus1.screen.main.home.restaurant

import androidx.annotation.StringRes
import com.betona.fastcampus1.R

enum class RestaurantCategory(
    @StringRes val categoryNameId: Int,
    @StringRes val categoryTypeId: Int
) {
    ALL(R.string.all,R.string.all_type)
}