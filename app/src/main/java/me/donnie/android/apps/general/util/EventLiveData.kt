package me.donnie.android.apps.general.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

/**
 * @author: zhongzhan
 * @email: zhongzhan@weeget.cn
 * @date: 2020/12/24 10:46
 */
class EventLiveData<T> : MutableLiveData<T>() {

    private val eventObservers = mutableMapOf<Observer<in T>, EventObserver<T>>()

    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        val eventObserver = eventObservers.getOrPut(observer) { EventObserver(observer) }
        super.observe(owner, eventObserver)
    }

    override fun observeForever(observer: Observer<in T>) {
        val eventObserver = eventObservers.getOrPut(observer) { EventObserver(observer) }
        super.observeForever(eventObserver)
    }

    override fun removeObserver(observer: Observer<in T>) {
        if (observer is EventObserver) {
            eventObservers.values.removeAll { it == observer }
            super.removeObserver(observer)
        } else {
            val eventObserver = eventObservers[observer] ?: return
            super.removeObserver(eventObserver)
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun getValue(): T = super.getValue() as T

    override fun setValue(value: T) {
        eventObservers.values.forEach { it.expectValue() }
        super.setValue(value)
    }

    private class EventObserver<T>(private val observer: Observer<in T>) : Observer<T> {
        private var expected = false

        override fun onChanged(value: T) {
            if (!expected) {
                return
            }
            observer.onChanged(value)
            expected = false
        }

        fun expectValue() {
            expected = true
        }
    }

}