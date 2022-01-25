package com.betona.fastcampus1.screen.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.Job
import org.koin.android.ext.android.bind

abstract class BaseActivity<VM: BaseViewModel,VB: ViewBinding>: AppCompatActivity() {
    abstract val viewModel:VM
    protected lateinit var binding: VB

    private lateinit var fetchJob : Job

    abstract fun getViewBinding(): VB

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = getViewBinding()
        setContentView(binding.root)
        initState()
    }
    open fun initState(){
        initViews()
        fetchJob = viewModel.fetData()
    }

    open fun initViews() = Unit

    abstract fun observeData()

    override fun onDestroy() {
        if(fetchJob.isActive) {
            fetchJob.cancel()
        }
        super.onDestroy()
    }
}