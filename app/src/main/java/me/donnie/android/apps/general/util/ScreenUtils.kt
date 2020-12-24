package me.donnie.android.apps.general.util

import android.content.res.Configuration
import me.donnie.android.apps.general.app.application

/**
 * @author: zhongzhan
 * @email: zhongzhan@weeget.cn
 * @date: 2020/12/24 10:20
 */
object ScreenUtils {

    fun isPortrait(): Boolean =
        application.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT

}