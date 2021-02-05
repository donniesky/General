package me.donnie.android.apps.general.extension

import android.content.res.Resources
import kotlin.math.roundToInt

/**
 * @author: zhongzhan
 * @email: zhongzhan@weeget.cn
 * @date: 2021/1/4 16:35
 */
/**
 * sp to px
 */
val Int.sp: Int
    get() = (this * Resources.getSystem().displayMetrics.scaledDensity).roundToInt()
/**
 * dp to px
 */
val Int.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density).roundToInt()

/**
 * px to dp
 */
val Int.px2dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).roundToInt()