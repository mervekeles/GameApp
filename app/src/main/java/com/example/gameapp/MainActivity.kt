package com.example.gameapp

import android.content.ActivityNotFoundException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("MainActivity", "onCreate Called")
        setContentView(R.layout.activity_main)
        val navView = findViewById<NavigationView>(R.id.navView)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment

        drawerLayout = findViewById(R.id.drawerLayout)

        NavigationUI.setupWithNavController(navView, navHostFragment.navController)

        //to add up button
        //NavigationUI.setupActionBarWithNavController(this, navHostFragment.navController)
        //to add hamburger icon
        NavigationUI.setupActionBarWithNavController(this, navHostFragment.navController, drawerLayout)
    }
    //to get up button, Add support for an Up button
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment_container)
        //return navController.navigateUp()
        return NavigationUI.navigateUp(navController, drawerLayout)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.optionsmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_container)
        when (item.itemId) {
            R.id.shareMenuButton -> onShare()
        }
        return item.onNavDestinationSelected(navController) ||
                super.onOptionsItemSelected(item)

    }
    private fun onShare() {
        val shareIntent = ShareCompat.IntentBuilder.from(this)
            .setText("Shareing sme game app")
            .setType("text/plain")
            .intent
        try {
            startActivity(shareIntent)
        } catch (ex: ActivityNotFoundException) {
            Toast.makeText(this, "No sharing available",
                Toast.LENGTH_LONG).show()
        }
    }


    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "onStart Called")

    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MainActivity", "onRestart Called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("MainActivity", "onResume Called")

    }
    override fun onPause() {
        super.onPause()
        Log.i("MainActivity", "onPause Called")

    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity", "onStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity", "onDestroy Called")

    }
}


//data class User(val name: String, val email: String): Parcelable
