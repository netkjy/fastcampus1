package com.betona.fastcampus1.screen.main.my

import com.betona.fastcampus1.databinding.FragmentHomeBinding
import com.betona.fastcampus1.databinding.FragmentMyBinding
import com.betona.fastcampus1.screen.base.BaseFragment
import com.betona.fastcampus1.screen.main.home.HomeFragment
import org.koin.android.viewmodel.ext.android.viewModel

class MyFragment:BaseFragment<MyViewModel, FragmentMyBinding>(){
    override val viewModel by viewModel<MyViewModel>()
    override fun getViewBinding(): FragmentMyBinding = FragmentMyBinding.inflate(layoutInflater)

    override fun observeData() {
        TODO("Not yet implemented")
    }
    companion object {
        fun newInstance() = MyFragment()
        const val TAG = "MyFragment"
    }
}