package com.example.navigationcomponentexample.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.core.view.GravityCompat
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI

import com.example.navigationcomponentexample.R
import kotlinx.android.synthetic.main.fragment_bottom_nav.*
import kotlinx.android.synthetic.main.fragment_drawer.*
import kotlinx.android.synthetic.main.fragment_drawer.toolbar

/**
 * A simple [Fragment] subclass.
 */
class DrawerFragment : Fragment(R.layout.fragment_drawer) {
    lateinit var navHostFragment: NavHostFragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupNavigation()
    }

    fun setupNavigation(){
        // since I'm using a nested fragment
        navHostFragment = childFragmentManager.findFragmentById(R.id.drawer_nav_host) as NavHostFragment

        //this will automatically handle the toolbar
        val appBarConfiguration = AppBarConfiguration
            .Builder(
                R.id.feedFragment,
                R.id.profileFragment
            )
            .build()

        NavigationUI.setupWithNavController(toolbar, navHostFragment.navController, drawerLayout)
        NavigationUI.setupWithNavController(navView, navHostFragment.navController)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.feedFragment ->{
                    var navOptions = NavOptions.Builder().setPopUpTo(R.id.nav_graph_drawer, true).build()
                    navHostFragment.navController.navigate(R.id.feedFragment, null,  navOptions)

                }
                R.id.profileFragment -> {
                    if(isValidDestination(R.id.profileFragment)) {
                        navHostFragment.navController.navigate(R.id.profileFragment)
                    }
                }
            }
            it.setChecked(true)
            drawerLayout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }

        navHostFragment.navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when(destination.id){
                R.id.feedDetailFragment ->{
                    toolbar.title = arguments?.getString("title")
                }
                else ->{
                    toolbar.title = destination.label
                }
            }

        }

    }

    fun isValidDestination(destination:Int):Boolean{
        return destination != navHostFragment.navController.currentDestination?.id
    }
}
