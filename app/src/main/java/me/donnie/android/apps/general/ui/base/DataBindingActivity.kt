package me.donnie.android.apps.general.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * @author: zhongzhan
 * @email: zhongzhan@weeget.cn
 * @date: 2020/12/21 11:06
 */
abstract class DataBindingActivity<B : ViewDataBinding> : AbstractActivity() {

    lateinit var binding: B

    @LayoutRes
    abstract fun getLayoutResId(): Int

    override fun initView(savedInstanceState: Bundle?) {
        binding = DataBindingUtil.setContentView(this, getLayoutResId())
        binding.lifecycleOwner = this
    }

    override fun onDestroy() {
        binding.unbind()
        super.onDestroy()
    }
}