package com.example.navigationcomponentexample.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import com.example.navigationcomponentexample.R
import com.example.navigationcomponentexample.utils.NotificationHelper
import kotlinx.android.synthetic.main.fragment_welcome.*

/**
 * A simple [Fragment] subclass.
 */
class WelcomeFragment : Fragment(R.layout.fragment_welcome) {
    val navController by lazy { findNavController(view!!) }
    private val notificationHelper by lazy { NotificationHelper(activity!!.application) }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //create a click listener that automatically redirect the user using the action id
//        navBottomBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_welcomeFragment_to_bottomNavFragment))
        navBottomBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(WelcomeFragmentDirections.actionWelcomeFragmentToBottomNavFragment())
        }

        //navigate by code
        fragmentsBtn.setOnClickListener {
            navController.navigate(WelcomeFragmentDirections.actionWelcomeFragmentToFirstStepFragment())
        }

        drawerBtn.setOnClickListener {
            navController.navigate(WelcomeFragmentDirections.actionWelcomeFragmentToDrawerFragment())
        }

        dialogBtn.setOnClickListener {
            navController.navigate(WelcomeFragmentDirections.actionWelcomeFragmentToDialogFragment())
        }

        notificationBtn.setOnClickListener {
            notificationHelper.sendLocalNotification("New notification!")
        }

        resultBtn.setOnClickListener {
            navController.navigate(WelcomeFragmentDirections.actionWelcomeFragmentToStartResultFragment())
        }
    }


}
