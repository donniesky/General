package me.donnie.android.apps.general.ui.main

import android.os.Bundle
import me.donnie.android.apps.general.R
import me.donnie.android.apps.general.databinding.FragmentMainBinding
import me.donnie.android.apps.general.ui.base.DataBindingFragment

/**
 * @author: zhongzhan
 * @email: zhongzhan@weeget.cn
 * @date: 2020/12/23 17:43
 */
class MainFragment : DataBindingFragment<FragmentMainBinding>() {

    override fun getLayoutResId(): Int = R.layout.fragment_main

    override fun initView(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            // TODO
        }
    }

}