package com.betona.fastcampus1.util.provider

import android.content.res.ColorStateList
import androidx.annotation.StringRes
import java.util.*

interface ResourcesProvider {

    fun getString(@StringRes resId:Int):String
    fun getString(@StringRes resId:Int,vararg formArgs: Any ):String
    fun getColor(resId: Int): Int
    fun getColorStateList(resId: Int): ColorStateList


}