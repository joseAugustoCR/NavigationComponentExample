package com.example.navigationcomponentexample.fragments.fragmentsflow


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigationcomponentexample.R
import kotlinx.android.synthetic.main.fragment_second_step.*


/**
 * A simple [Fragment] subclass.
 */
class SecondStepFragment : Fragment(R.layout.fragment_second_step) {
    val navController by lazy { findNavController(activity!!, R.id.nav_host_fragment) }
    val args: SecondStepFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        nextBtn.setOnClickListener {
            if(editText.text.toString().isNotEmpty()) {
//                var navOptions = NavOptions.Builder().setPopUpTo(R.id.welcomeFragment, true).build()
                navController?.navigate(
                    SecondStepFragmentDirections.actionSecondStepFragmentToThirdFragment(
                        args.username,
                        editText.text.toString()
                    )
                )
            }
        }

        titleText.text = "Hi, ${args.username}!\nThis is just a navigation component example. Tell me what's on your mind?"
    }

}
