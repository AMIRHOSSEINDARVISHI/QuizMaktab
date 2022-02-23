package code.with.cal.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import code.with.cal.quiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bindingMain: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingMain = ActivityMainBinding.inflate(layoutInflater)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_main) as NavHostFragment

        navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(navController.graph)

        bindingMain.bottomNavigationMain.setOnItemSelectedListener { result ->
            when (result.itemId) {
                R.id.menu_home -> {
                    navController.popBackStack()
                    navController.navigate(R.id.homeFragment)
                }
                R.id.menu_search -> {
                    navController.popBackStack()
                    navController.navigate(R.id.searchFragment)
                }
            }
            true
        }

        setContentView(bindingMain.root)

    }
}