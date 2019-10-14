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
import kotlinx.android.synthetic.main.fragment_third.*

/**
 * A simple [Fragment] subclass.
 */
class ThirdFragment : Fragment(R.layout.fragment_third) {
    val navController by lazy { findNavController(activity!!, R.id.nav_controller) }
    lateinit var username:String
    lateinit var description:String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        username = arguments?.getString("username").toString()
        description = arguments?.getString("description").toString()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        nextBtn.setOnClickListener {
            navController?.navigate(R.id.action_thirdFragment_to_welcomeFragment)
        }
        usernameText.text = "$username:"
        descriptionText.text = "\"$description\""

    }


}
