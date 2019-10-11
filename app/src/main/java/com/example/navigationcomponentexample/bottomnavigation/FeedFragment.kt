package com.example.navigationcomponentexample.bottomnavigation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.navigationcomponentexample.R
import kotlinx.android.synthetic.main.fragment_feed.*

/**
 * A simple [Fragment] subclass.
 */
class FeedFragment : Fragment() {
    var navController: NavController? = null
    var mainNavController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //get the current navController (nested nav controller)
        navController = Navigation.findNavController(view)
        //get the main navController
        mainNavController = Navigation.findNavController(activity!!, R.id.nav_controller)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        backToWelcomeBtn.setOnClickListener {
            mainNavController?.navigate(R.id.action_bottomNavFragment_to_welcomeFragment)
        }
    }


}
