package com.beingdeveloper.dropdown

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import android.widget.Toast
import android.view.MenuItem





class MainActivity : AppCompatActivity() {


    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private var isTeamManagementExpanded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)

        // Handle item selection in Navigation Drawer
        navigationView.setNavigationItemSelectedListener { menuItem ->
            handleMenuItemClick(menuItem)
            true
        }
    }

    private fun handleMenuItemClick(menuItem: MenuItem) {
        when (menuItem.itemId) {
            R.id.nav_home -> {
                showToast("Home clicked")
                drawerLayout.closeDrawers()
            }
            R.id.nav_team_management -> {
                toggleTeamManagementMenu()
            }
            R.id.nav_sub_team -> {
                showToast("Sub Team clicked")
                drawerLayout.closeDrawers()
            }
            R.id.nav_full_team -> {
                showToast("Full Team clicked")
                drawerLayout.closeDrawers()
            }
        }
    }

    private fun toggleTeamManagementMenu() {
        // Toggle visibility of Sub Team and Full Team items
        isTeamManagementExpanded = !isTeamManagementExpanded
        navigationView.menu.findItem(R.id.nav_sub_team).isVisible = isTeamManagementExpanded
        navigationView.menu.findItem(R.id.nav_full_team).isVisible = isTeamManagementExpanded
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}