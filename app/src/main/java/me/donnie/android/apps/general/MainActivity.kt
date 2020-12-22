package me.donnie.android.apps.general

import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import me.donnie.android.apps.general.databinding.ActivityMainBinding
import me.donnie.android.apps.general.ui.base.DataBindingActivity

class MainActivity : DataBindingActivity<ActivityMainBinding>() {

    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun initCustomTheme() {
        setTheme(R.style.Theme_General)
    }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
    }

    override fun onWindowInsetChanged(insets: WindowInsetsCompat) {
        Log.d("Main", "top inset: ${insets.getInsets(WindowInsetsCompat.Type.systemBars()).top}")
    }
}