package com.betona.fastcampus1.screen.main.home

import com.betona.fastcampus1.databinding.FragmentHomeBinding
import com.betona.fastcampus1.screen.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment:BaseFragment<HomeViewModel, FragmentHomeBinding>(){
    override val viewModel by viewModel<HomeViewModel>()
    override fun getViewBinding(): FragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)

    override fun observeData() {
        TODO("Not yet implemented")
    }

    companion object {
        fun newInstance() = HomeFragment()
        const val TAG = "HomeFragment"
    }

}