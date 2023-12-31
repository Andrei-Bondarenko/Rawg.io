package com.example.common.mvvm

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import timber.log.Timber

abstract class BaseFragment(@LayoutRes layoutRes: Int) : Fragment(layoutRes) {

    abstract fun initViews(view: View)

    abstract fun bind()

    override fun onStart() {
        super.onStart()
        Timber.d("=== onStart === ${javaClass.name} ")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews(view)
        bind()
    }

    fun <T : Any?, F : Flow<T>> observe(flow: F, body: (T) -> Unit) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                flow.collect { body(it) }
            }
        }
    }
}