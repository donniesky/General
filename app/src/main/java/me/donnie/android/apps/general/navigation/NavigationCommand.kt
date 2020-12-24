package me.donnie.android.apps.general.navigation

import android.content.Context
import androidx.navigation.NavController

/**
 * @author: zhongzhan
 * @email: zhongzhan@weeget.cn
 * @date: 2020/12/24 10:48
 */
typealias NavigationCommand = NavController.(Context) -> Unit