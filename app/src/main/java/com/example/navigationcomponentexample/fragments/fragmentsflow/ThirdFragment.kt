package com.example.navigationcomponentexample.fragments.fragmentsflow


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigationcomponentexample.R
import kotlinx.android.synthetic.main.fragment_third.*

/**
 * A simple [Fragment] subclass.
 */
class ThirdFragment : Fragment(R.layout.fragment_third) {
    val navController by lazy { findNavController(activity!!, R.id.nav_host_fragment) }
    val args: ThirdFragmentArgs by navArgs()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        nextBtn.setOnClickListener {
            navController?.navigate(ThirdFragmentDirections.actionThirdFragmentToWelcomeFragment())
        }
        usernameText.text = "${args.username}:"
        descriptionText.text = "\"${args.description}\""

    }


}
