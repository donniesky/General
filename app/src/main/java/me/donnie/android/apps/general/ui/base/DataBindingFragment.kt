package me.donnie.android.apps.general.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * @author: zhongzhan
 * @email: zhongzhan@weeget.cn
 * @date: 2020/12/21 11:14
 */
abstract class DataBindingFragment<B : ViewDataBinding> : AbstractFragment() {

    lateinit var binding: B

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    @LayoutRes
    abstract fun getLayoutResId(): Int

    override fun onDestroyView() {
        binding.unbind()
        super.onDestroyView()
    }
}