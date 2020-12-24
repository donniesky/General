package me.donnie.android.apps.general.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

/**
 * @author: zhongzhan
 * @email: zhongzhan@weeget.cn
 * @date: 2020/12/22 14:46
 */
abstract class AbstractFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutResId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView(savedInstanceState)
        initData()
    }

    @LayoutRes
    abstract fun getLayoutResId(): Int
    abstract fun initView(savedInstanceState: Bundle?)
    open fun initData() {}

}