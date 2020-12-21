package me.donnie.android.apps.general.app

import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import me.donnie.android.apps.general.util.AdaptScreenUtils

/**
 * @author: zhongzhan
 * @email: zhongzhan@weeget.cn
 * @date: 2020/12/21 10:47
 */
abstract class AppActivity : AppCompatActivity() {

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
}