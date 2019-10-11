package com.example.navigationcomponentexample.bottomnavigation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.NavController
import androidx.navigation.Navigation

import com.example.navigationcomponentexample.R
import kotlinx.android.synthetic.main.fragment_settings.*

/**
 * A simple [Fragment] subclass.
 */
class SettingsFragment : Fragment() {
    var navController: NavController? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        backToProfile.setOnClickListener {
            navController?.navigate(R.id.action_settingsFragment_to_profileFragment)
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,  object :
            OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                navController?.navigate(R.id.action_settingsFragment_to_profileFragment)
            }
        })

    }


}
