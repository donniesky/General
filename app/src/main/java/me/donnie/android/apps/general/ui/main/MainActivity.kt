package me.donnie.android.apps.general.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import me.donnie.android.apps.general.R
import me.donnie.android.apps.general.databinding.ActivityMainBinding
import me.donnie.android.apps.general.navigation.NavigationDispatcher
import me.donnie.android.apps.general.ui.base.DataBindingActivity

class MainActivity : DataBindingActivity<ActivityMainBinding>() {

    private val navigationDispatcher: NavigationDispatcher by viewModels()

    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun initCustomTheme() {
        setTheme(R.style.Theme_General_TransparentStatusBar)
    }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        navigationDispatcher.navigationEvent.observe(this) { command ->
            findNavController(R.id.nav_host_fragment).command(this)
        }
    }

    override fun onWindowInsetChanged(insets: WindowInsetsCompat) {
        Log.d("Main", "top inset: ${insets.getInsets(WindowInsetsCompat.Type.systemBars()).top}")
    }
}