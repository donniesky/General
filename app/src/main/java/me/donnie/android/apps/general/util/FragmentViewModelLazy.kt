package me.donnie.android.apps.general.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner

/**
 * @author: zhongzhan
 * @email: zhongzhan@weeget.cn
 * @date: 2020/12/24 11:56
 */
inline fun <reified VM : ViewModel> Fragment.viewModels(
    noinline ownerProducer: () -> ViewModelStoreOwner = { this },
    noinline factoryProducer: (() -> () -> VM)? = null
) = viewModels<VM>(ownerProducer, factoryProducer?.let {
    {
        val factory = it()
        object : androidx.lifecycle.ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>) = factory() as T
        }
    }
})

inline fun <reified VM : ViewModel> Fragment.statedViewModels(
    noinline ownerProducer: () -> ViewModelStoreOwner = { this },
    noinline factoryProducer: (() -> (handle: SavedStateHandle) -> VM)? = null
) = viewModels<VM>(ownerProducer, factoryProducer?.let {
    {
        val factory = it()
        object : AbstractSavedStateViewModelFactory(this, arguments) {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T {
                return factory(handle) as T
            }
        }
    }
})

inline fun <reified VM : ViewModel> Fragment.activityViewModels(
    noinline factoryProducer: (() -> () -> VM)? = null
) = viewModels(::requireActivity, factoryProducer)