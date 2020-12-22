package me.donnie.android.apps.general.ui.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

/**
 * @author: zhongzhan
 * @email: zhongzhan@weeget.cn
 * @date: 2020/12/22 14:46
 */
abstract class AbstractFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView(savedInstanceState)
        initData()
    }

    abstract fun initView(savedInstanceState: Bundle?)
    open fun initData() {}

}