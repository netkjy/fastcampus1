package com.betona.fastcampus1.widget.adapter.viewholder

import com.betona.fastcampus1.databinding.ViewholderEmptyBinding
import com.betona.fastcampus1.model.Model
import com.betona.fastcampus1.screen.base.BaseViewModel
import com.betona.fastcampus1.util.provider.ResourcesProvider
import com.betona.fastcampus1.widget.adapter.listener.AdapterListener

class EmptyViewHolder(
    private val binding: ViewholderEmptyBinding,
    viewModel: BaseViewModel,
    resourcesProvider: ResourcesProvider
):ModelViewHolder<Model>(binding,viewModel,resourcesProvider) {
    override fun reset() =Unit

    override fun bindViews(model: Model, adapterListener: AdapterListener) =Unit

}