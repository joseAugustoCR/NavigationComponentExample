package com.example.navigationcomponentexample.bottomnavigation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI

import com.example.navigationcomponentexample.R
import kotlinx.android.synthetic.main.fragment_bottom_nav.*

/**
 * A simple [Fragment] subclass.
 */
class BottomNavFragment : Fragment() {
    lateinit var navHostFragment: NavHostFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_nav, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // since I'm using a nested fragment
        navHostFragment = childFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        //setup the bottom navigation
        NavigationUI.setupWithNavController(bottomNavigationView, navHostFragment.navController)

        //this will automatically handle the toolbar
        val appBarConfiguration = AppBarConfiguration
            .Builder(
                R.id.feedFragment,
                R.id.profileFragment
            )
            .build()
        NavigationUI.setupWithNavController(toolbar, navHostFragment.navController, appBarConfiguration)

        navHostFragment.navController.addOnDestinationChangedListener { controller, destination, arguments ->
            toolbar.title = destination.label
        }



    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    fun setUpNavigation(){

    }

}
