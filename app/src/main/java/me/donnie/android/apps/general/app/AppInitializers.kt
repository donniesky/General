package me.donnie.android.apps.general.app

import android.app.Application
import android.content.Context
import androidx.startup.Initializer

/**
 * @author: zhongzhan
 * @email: zhongzhan@weeget.cn
 * @date: 2020/12/21 15:43
 */
lateinit var application: Application private set

class AppInitializer : Initializer<Boolean> {

    override fun create(context: Context): Boolean {
        application = context as Application
        return true
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }
}