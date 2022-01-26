package com.betona.fastcampus1.screen.main.home

import android.widget.TableLayout
import androidx.core.view.isVisible
import com.betona.fastcampus1.databinding.FragmentHomeBinding

import com.betona.fastcampus1.screen.base.BaseFragment
import com.betona.fastcampus1.screen.main.home.restaurant.RestaurantCategory
import com.betona.fastcampus1.screen.main.home.restaurant.RestaurantListFragment
import com.betona.fastcampus1.widget.adapter.RestaurantListFragmentPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment:BaseFragment<HomeViewModel, FragmentHomeBinding>(){
    override val viewModel by viewModel<HomeViewModel>()
    override fun getViewBinding(): FragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)

    private lateinit var viewPagerAdapter: RestaurantListFragmentPagerAdapter

    override fun initViews() {
        super.initViews()
        initViewPager()
    }

    private fun initViewPager() = with(binding) {
        val restaurantCategories = RestaurantCategory.values()
        orderChipGroup.isVisible = true
        if(::viewPagerAdapter.isInitialized.not()) {
            val restaurantListFragmentList =restaurantCategories.map {
                RestaurantListFragment.newInstance(it)
            }

            viewPagerAdapter = RestaurantListFragmentPagerAdapter(
                this@HomeFragment,
                restaurantListFragmentList
                )
            viewPager.adapter = viewPagerAdapter
        }
        viewPager.offscreenPageLimit = restaurantCategories.size
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setText(restaurantCategories[position].categoryNameId)
        }.attach()
    }


    override fun observeData() { }

    companion object {
        fun newInstance() = HomeFragment()
        const val TAG = "HomeFragment"
    }

}