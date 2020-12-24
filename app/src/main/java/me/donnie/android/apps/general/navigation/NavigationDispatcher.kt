package me.donnie.android.apps.general.navigation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import me.donnie.android.apps.general.util.EventLiveData

/**
 * @author: zhongzhan
 * @email: zhongzhan@weeget.cn
 * @date: 2020/12/24 10:43
 */
class NavigationDispatcher : ViewModel() {

    private val _navigationEvent = EventLiveData<NavigationCommand>()
    val navigationEvent: LiveData<NavigationCommand> = _navigationEvent

    fun navigate(command: NavigationCommand?) {
        command?.let {
            _navigationEvent.value = it
        }
    }
}