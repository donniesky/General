package me.donnie.android.apps.general.extension

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * @author: zhongzhan
 * @email: zhongzhan@weeget.cn
 * @date: 2020/12/21 11:23
 */
inline fun <reified T : ViewDataBinding> AppCompatActivity.binding() =
    ActivityDataBindingDelegate(T::class.java, this)

inline fun <reified T : ViewDataBinding> Fragment.binding() =
    FragmentDataBindingDelegate(T::class.java, this)

class ActivityDataBindingDelegate<T : ViewDataBinding>(
    classes: Class<T>,
    activity: AppCompatActivity
) : ReadOnlyProperty<AppCompatActivity, T> {

    init {
        activity.lifecycle.addObserver { destroyed() }
    }

    private val inflater = classes.getMethod("inflate", LayoutInflater::class.java)
    private var binding: T? = null

    @Suppress("UNCHECKED_CAST")
    override fun getValue(thisRef: AppCompatActivity, property: KProperty<*>): T {
        return binding?.run {
            this
        } ?: let {
            val viewBinding = inflater.invoke(null, thisRef.layoutInflater) as T
            viewBinding.lifecycleOwner = thisRef
            thisRef.setContentView(viewBinding.root)
            viewBinding.apply { binding = this }
        }
    }

    private fun destroyed() {
        binding?.unbind()
        binding = null
    }
}

class FragmentDataBindingDelegate<T : ViewDataBinding>(
    classes: Class<T>,
    fragment: Fragment
) : ReadOnlyProperty<Fragment, T> {

    init {
        fragment.lifecycle.addObserver { destroyed() }
    }

    private val view = classes.getMethod("bind", View::class.java)
    private var binding: T? = null

    @Suppress("UNCHECKED_CAST")
    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        return binding?.run {
            this
        } ?: let {
            val viewBinding = view.invoke(null, thisRef.view) as T
            viewBinding.lifecycleOwner = thisRef
            return viewBinding.apply { binding = this }
        }
    }

    private fun destroyed() {
        binding?.unbind()
        binding = null
    }
}