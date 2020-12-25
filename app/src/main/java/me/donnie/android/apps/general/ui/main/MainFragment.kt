package me.donnie.android.apps.general.ui.main

import android.os.Bundle
import androidx.core.view.isVisible
import io.flutter.embedding.android.FlutterFragment
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
import me.donnie.android.apps.general.R
import me.donnie.android.apps.general.databinding.FragmentMainBinding
import me.donnie.android.apps.general.ui.base.DataBindingFragment

/**
 * @author: zhongzhan
 * @email: zhongzhan@weeget.cn
 * @date: 2020/12/23 17:43
 */
class MainFragment : DataBindingFragment<FragmentMainBinding>() {

    lateinit var flutterFragment: FlutterFragment

    override fun getLayoutResId(): Int = R.layout.fragment_main

    override fun initView(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            flutterFragment = FlutterFragment.withNewEngine()
                .initialRoute("From MainFragment to FlutterFragment")
                .build()
            childFragmentManager.beginTransaction()
                .add(R.id.flutter_container, flutterFragment)
                .commitAllowingStateLoss()
        }

        binding.layout.addOnFirstFrameRenderedListener(object : FlutterUiDisplayListener {
            override fun onFlutterUiDisplayed() {
                binding.progress.isVisible = false
                binding.text.isVisible = false
            }

            override fun onFlutterUiNoLongerDisplayed() {
                binding.progress.isVisible = false
                binding.text.isVisible = true
            }
        })
    }

}