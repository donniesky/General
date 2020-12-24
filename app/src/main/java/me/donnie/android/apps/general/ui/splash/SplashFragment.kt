package me.donnie.android.apps.general.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.navigation.Navigation
import me.donnie.android.apps.general.R
import me.donnie.android.apps.general.SplashGraphDirections
import me.donnie.android.apps.general.ui.base.AbstractFragment

/**
 * @author: zhongzhan
 * @email: zhongzhan@weeget.cn
 * @date: 2020/12/23 17:03
 */
class SplashFragment : AbstractFragment() {

    private val handler = Handler(Looper.myLooper()!!)

    override fun getLayoutResId(): Int = R.layout.fragment_splash

    override fun initView(savedInstanceState: Bundle?) {
        handler.postDelayed({
            (0..1).random().let {
                when (it) {
                    0 -> Navigation.findNavController(requireView())
                        .navigate(SplashGraphDirections.splashToLoggedIn(null))
                    1 -> Navigation.findNavController(requireView()).navigate(R.id.splash_to_logged_out)
                }
            }
        }, 1000)
    }

    override fun onDestroyView() {
        handler.removeCallbacksAndMessages(null)
        super.onDestroyView()
    }
}