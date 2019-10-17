package com.example.navigationcomponentexample.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController

import com.example.navigationcomponentexample.R
import kotlinx.android.synthetic.main.fragment_profile.*

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment(R.layout.fragment_profile) {
    val navController by lazy { findNavController(view!!) }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        settingsBtn.setOnClickListener {
            navController.navigate(ProfileFragmentDirections.actionProfileFragmentToSettingsFragment())
        }

    }

}
