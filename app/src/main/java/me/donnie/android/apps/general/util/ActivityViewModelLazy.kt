package me.donnie.android.apps.general.util

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

/**
 * @author: zhongzhan
 * @email: zhongzhan@weeget.cn
 * @date: 2020/12/24 11:39
 */
inline fun <reified VM : ViewModel> ComponentActivity.statedViewModels(
    noinline factoryProducer: (() -> (handle: SavedStateHandle) -> VM)? = null
) = viewModels<VM>(factoryProducer?.let {
    {
        val factory = it()
        object : AbstractSavedStateViewModelFactory(this, intent.extras) {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T {
                return factory(handle) as T
            }
        }
    }
})

inline fun <reified VM : ViewModel> ComponentActivity.paramViewModels(
    noinline factoryProducer: (() -> () -> VM)? = null
) = viewModels<VM>(factoryProducer?.let {
    {
        val factory = it()
        object : androidx.lifecycle.ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>) = factory() as T
        }
    }
})