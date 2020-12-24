package me.donnie.android.apps.general.ui.login

import androidx.lifecycle.ViewModel
import me.donnie.android.apps.general.LoggedOutGraphDirections
import me.donnie.android.apps.general.navigation.NavigationDispatcher

/**
 * @author: zhongzhan
 * @email: zhongzhan@weeget.cn
 * @date: 2020/12/23 15:15
 */
class LoginViewModel(
    private val dispatcher: NavigationDispatcher
) : ViewModel() {

    fun login() {
        dispatcher.navigate {
            navigate(LoggedOutGraphDirections.loggedOutToLoggedIn(null))
        }
    }

}