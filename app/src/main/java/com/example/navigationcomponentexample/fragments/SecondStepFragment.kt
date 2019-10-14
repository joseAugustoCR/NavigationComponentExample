package com.example.navigationcomponentexample.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import com.example.navigationcomponentexample.R
import kotlinx.android.synthetic.main.fragment_second_step.*

/**
 * A simple [Fragment] subclass.
 */
class SecondStepFragment : Fragment(R.layout.fragment_second_step) {
    val navController by lazy { findNavController(activity!!, R.id.nav_controller) }

    lateinit var username:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        username = arguments?.getString("username").toString()
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        nextBtn.setOnClickListener {
            if(editText.text.toString().isNotEmpty()) {
                val bundle = bundleOf(
                    "username" to username,
                    "description" to editText.text.toString()
                    )
                navController?.navigate(R.id.action_secondStepFragment_to_thirdFragment, bundle)
            }
        }

        titleText.text = "Hi, $username!\nThis is just a navigation component example. Tell me what's on your mind?"
    }

}
