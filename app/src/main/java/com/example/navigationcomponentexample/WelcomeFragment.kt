package com.example.navigationcomponentexample


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NavigationRes
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import kotlinx.android.synthetic.main.fragment_welcome.*

/**
 * A simple [Fragment] subclass.
 */
class WelcomeFragment : Fragment(R.layout.fragment_welcome) {
    val navController by lazy { findNavController(view!!) }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //create a click listener that automatically redirect the user using the action id
//        navBottomBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_welcomeFragment_to_bottomNavFragment))
        navBottomBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_welcomeFragment_to_bottomNavFragment)
        }

        //navigate by code
        fragmentsBtn.setOnClickListener {
            navController.navigate(R.id.action_welcomeFragment_to_firstStepFragment)
        }

        drawerBtn.setOnClickListener {
            navController.navigate(R.id.action_welcomeFragment_to_drawerFragment)
        }
    }


}
