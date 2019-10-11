package com.example.navigationcomponentexample


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NavigationRes
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_welcome.*

/**
 * A simple [Fragment] subclass.
 */
class WelcomeFragment : Fragment() {

    var navController:NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        //create a click listener that automatically redirect the user using the action id
//        navBottomBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_welcomeFragment_to_bottomNavFragment))
        navBottomBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_welcomeFragment_to_bottomNavFragment)
        }

        //navigate by code
        fragmentsBtn.setOnClickListener {
            navController?.navigate(R.id.action_welcomeFragment_to_firstStepFragment)
        }


    }


}
