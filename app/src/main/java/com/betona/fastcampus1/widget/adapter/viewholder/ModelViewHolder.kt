package com.betona.fastcampus1.widget.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.betona.fastcampus1.model.Model
import com.betona.fastcampus1.screen.base.BaseViewModel
import com.betona.fastcampus1.util.provider.ResourcesProvider
import com.betona.fastcampus1.widget.adapter.listener.AdapterListener

abstract class ModelViewHolder<M: Model> (
    binding: ViewBinding,
    private val viewModel: BaseViewModel,
    private val resourcesProvider: ResourcesProvider

): RecyclerView.ViewHolder(binding.root) {
    abstract fun reset()
    open fun bindData(model:M) {
        reset()
    }
    abstract fun bindView(model:M, adapterListener: AdapterListener)

}