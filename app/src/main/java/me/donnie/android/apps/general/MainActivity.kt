package me.donnie.android.apps.general

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import me.donnie.android.apps.general.app.AppActivity
import me.donnie.android.apps.general.databinding.ActivityMainBinding
import me.donnie.android.apps.general.extension.binding

class MainActivity : AppActivity() {

    private val binding: ActivityMainBinding by binding()

    override fun initCustomTheme() { setTheme(R.style.Theme_General) }

    override fun initView(savedInstanceState: Bundle?) {
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
    }
}