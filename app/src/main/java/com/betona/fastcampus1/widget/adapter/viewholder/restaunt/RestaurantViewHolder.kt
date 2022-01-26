package com.betona.fastcampus1.widget.adapter.viewholder.restaunt

import com.betona.fastcampus1.R

import com.betona.fastcampus1.databinding.ViewholderRestaurantBinding
import com.betona.fastcampus1.extensions.clear
import com.betona.fastcampus1.extensions.load
import com.betona.fastcampus1.model.restaurant.RestaurantModel
import com.betona.fastcampus1.screen.base.BaseViewModel
import com.betona.fastcampus1.util.provider.ResourcesProvider

import com.betona.fastcampus1.widget.adapter.listener.AdapterListener
import com.betona.fastcampus1.widget.adapter.listener.RestaurantListListener
import com.betona.fastcampus1.widget.adapter.viewholder.ModelViewHolder

class RestaurantViewHolder(
    private val binding: ViewholderRestaurantBinding,
    viewModel: BaseViewModel,
    resourcesProvider: ResourcesProvider
): ModelViewHolder<RestaurantModel>(binding,viewModel,resourcesProvider) {
    override fun reset() =with(binding) {
        restaurantImage.clear()
    }

    override fun bindData(model: RestaurantModel) {
        super.bindData(model)
        with(binding) {
            restaurantImage.load(model.restaurantImageUrl,24f)
            restaurantTitleText.text = model.restaurantTitle
            gradeText.text = resourcesProvider.getString(R.string.grade_format,model.grade)
            reviewCountText.text = resourcesProvider.getString(R.string.review_count,model.reviewCount)
            val (minTime,maxTime) = model.deliveryTimeRange
            deliveryTimeText.text = resourcesProvider.getString(R.string.delivery_time,minTime,maxTime)
            val (midTip, maxTip) = model.deliveryTipRange
            deliveryTipText.text = resourcesProvider.getString(R.string.delivery_tip,midTip,maxTip)
        }

    }

    override fun bindViews(model: RestaurantModel, adapterListener: AdapterListener)  = with(binding){
        if(adapterListener is RestaurantListListener) {
            root.setOnClickListener {
                adapterListener.onClickItem(model)
            }
        }
    }

}