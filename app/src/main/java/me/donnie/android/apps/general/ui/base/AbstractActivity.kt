package me.donnie.android.apps.general.ui.base

import android.content.res.Resources
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.OnApplyWindowInsetsListener
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import me.donnie.android.apps.general.util.AdaptScreenUtils

/**
 * @author: zhongzhan
 * @email: zhongzhan@weeget.cn
 * @date: 2020/12/21 10:47
 */
abstract class AbstractActivity : AppCompatActivity() {

    private var isDelegateCreated = false

    override fun getDelegate(): AppCompatDelegate {
        val delegate = super.getDelegate()
        if (!isDelegateCreated) {
            isDelegateCreated = true
            // TODO Night theme init
        }
        return delegate
    }

    override fun getResources(): Resources {
        return AdaptScreenUtils.adaptWidth(super.getResources(), 1080)
    }

    override fun setContentView(view: View?) {
        super.setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(
            window.decorView.rootView,
            OnApplyWindowInsetsListener { _, insets ->
                onWindowInsetChanged(insets)
                return@OnApplyWindowInsetsListener insets
            }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        // TODO Custom theme init
        initCustomTheme()
        super.onCreate(savedInstanceState)
        initView(savedInstanceState)
        initData()
    }

    abstract fun initView(savedInstanceState: Bundle?)
    open fun initData() {}
    open fun initCustomTheme() {}

    open fun onWindowInsetChanged(insets: WindowInsetsCompat) {}
}