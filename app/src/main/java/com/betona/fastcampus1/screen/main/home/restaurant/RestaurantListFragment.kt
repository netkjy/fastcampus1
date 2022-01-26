package com.betona.fastcampus1.screen.main.home.restaurant

import android.util.Log
import android.widget.Toast
import androidx.core.os.bundleOf
import com.betona.fastcampus1.databinding.FragmentRestauntListBinding
import com.betona.fastcampus1.model.restaurant.RestaurantModel
import com.betona.fastcampus1.screen.base.BaseFragment
import com.betona.fastcampus1.util.provider.ResourcesProvider
import com.betona.fastcampus1.widget.adapter.ModelRecyclerAdapter
import com.betona.fastcampus1.widget.adapter.listener.RestaurantListListener
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

import org.koin.core.parameter.parametersOf

class RestaurantListFragment :
    BaseFragment<RestaurantListViewModel, FragmentRestauntListBinding>() {
    private val restaurantCategory by lazy { arguments?.getSerializable(RESTAURANT_CATEGORY_KEY) as RestaurantCategory }
    override val viewModel by viewModel<RestaurantListViewModel> { parametersOf(restaurantCategory) }
    override fun getViewBinding(): FragmentRestauntListBinding =
        FragmentRestauntListBinding.inflate(layoutInflater)

    val resourceProvider by inject<ResourcesProvider>()
    private val adapter by lazy {
        ModelRecyclerAdapter<RestaurantModel, RestaurantListViewModel>(
            listOf(),
            viewModel,
            resourceProvider,
            adapterListener = object : RestaurantListListener {
                override fun onClickItem(model: RestaurantModel) {
                    Toast.makeText(requireContext(),"${model}",Toast.LENGTH_LONG).show()
                }
            })
    }

    override fun initViews() = with(binding){
        recyclerView.adapter = adapter
    }

    override fun observeData() = viewModel.restaurantListLiveData.observe(viewLifecycleOwner) {
        viewModel.restaurantListLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    companion object {
        const val RESTAURANT_CATEGORY_KEY = "restaurantCategory"
        fun newInstance(restaurantCategory: RestaurantCategory): RestaurantListFragment {
            return RestaurantListFragment().apply {
                arguments = bundleOf(
                    RESTAURANT_CATEGORY_KEY to restaurantCategory
                )
            }
        }
    }

}