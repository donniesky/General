package me.donnie.android.apps.general.extension

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

/**
 * @author: zhongzhan
 * @email: zhongzhan@weeget.cn
 * @date: 2020/12/21 11:27
 */
fun Lifecycle.addObserver(destroyed: () -> Unit) {
    addObserver(LifecycleObserver(this, destroyed))
}

class LifecycleObserver(
    var lifecycle: Lifecycle?,
    val destroyed: () -> Unit
) : LifecycleEventObserver {
    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        val currentState = source.lifecycle.currentState
        if (currentState == Lifecycle.State.DESTROYED) {
            destroyed()
            lifecycle?.apply {
                removeObserver(this@LifecycleObserver)
                lifecycle = null
            }
        }
    }
}