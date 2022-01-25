package com.betona.fastcampus1.util.mapper

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import com.betona.fastcampus1.model.CellType
import com.betona.fastcampus1.model.Model
import com.betona.fastcampus1.screen.base.BaseViewModel
import com.betona.fastcampus1.util.provider.ResourcesProvider
import com.betona.fastcampus1.widget.adapter.viewholder.ModelViewHolder

object ModelViewHolderMapper {
    @Suppress("UNCHECKED_CAST")
    fun <M: Model> map(
        parent: ViewGroup,
        type:CellType,
        viewModel: BaseViewModel,
        resourcesProvider: ResourcesProvider
        ) : ModelViewHolder<M> {
        val inflater = LayoutInflater.from(parent.context)
        val viewHolder = when(type) {
            CellType.EMPTY_CELL ->
        }
        return viewHolder as ModelViewHolder<M>
    }
}