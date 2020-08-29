package com.android.daggerhiltwithmvvmrepositorywithhitapi.ui

import android.content.Context
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject
@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainNavHostFragment :NavHostFragment() {
    @Inject
    lateinit var fragmentFactory: MainFragmentFactoryClass
    override fun onAttach(context: Context) {
        super.onAttach(context)
        childFragmentManager.fragmentFactory = fragmentFactory
    }
}