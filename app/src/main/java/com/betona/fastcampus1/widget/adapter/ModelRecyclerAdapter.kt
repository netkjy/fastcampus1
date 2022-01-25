package com.betona.fastcampus1.widget.adapter

import android.content.res.loader.ResourcesProvider
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.betona.fastcampus1.model.Model
import com.betona.fastcampus1.screen.base.BaseViewModel
import com.betona.fastcampus1.widget.adapter.listener.AdapterListener
import com.betona.fastcampus1.widget.adapter.viewholder.ModelViewHolder

class ModelRecyclerAdapter<M: Model, VM:BaseViewModel> (
    private var modelList:List<Model>,
    private val viewModel: VM,
    private val resourceProvider: ResourcesProvider,
    private val adapterListener: AdapterListener
):ListAdapter<Model,ModelViewHolder<M>>(Model.DIFF_CALLBACK){
    override fun getItemCount(): Int = modelList.size
    override fun getItemViewType(position: Int): Int = modelList[position].type.ordinal
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder<M> {

    }

    override fun onBindViewHolder(holder: ModelViewHolder<M>, position: Int) {
        TODO("Not yet implemented")
    }


}